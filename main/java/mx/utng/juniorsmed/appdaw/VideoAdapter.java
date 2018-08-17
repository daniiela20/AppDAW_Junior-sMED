package mx.utng.juniorsmed.appdaw;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Alexa on 12/08/2018.
 */

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.VideoViewHolder> {
    List<YouTubeVideos> youtubeVideoList;

    public VideoAdapter(List<YouTubeVideos> youtubeVideoList) {
        this.youtubeVideoList = youtubeVideoList;
    }
    @Override
    public VideoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from( parent.getContext()).inflate(mx.utng.juniorsmed.appdaw.R.layout.activity_video_unit_one, parent, false);
        return new VideoViewHolder(view);
    }
    @Override
    public void onBindViewHolder(VideoViewHolder holder, int position) {
        holder.videoWeb.loadData( youtubeVideoList.get(position).getVideoUrl(), "text/html" , "utf-8" );
        holder.txtTitle.setText( youtubeVideoList.get(position).getTitle());
        holder.txtDescription.setText(youtubeVideoList.get(position).getDescription());
    }
    @Override
    public int getItemCount() {
        return youtubeVideoList.size();
    }
    public class VideoViewHolder extends RecyclerView.ViewHolder{
        WebView videoWeb;
        TextView txtTitle;
        TextView txtDescription;

        public VideoViewHolder(View itemView) {
            super(itemView);
            videoWeb = (WebView) itemView.findViewById(mx.utng.juniorsmed.appdaw.R.id.video_web_view);
            txtTitle = (TextView) itemView.findViewById(mx.utng.juniorsmed.appdaw.R.id.txt_title);
            txtDescription = (TextView)  itemView.findViewById(mx.utng.juniorsmed.appdaw.R.id.txt_description);
            videoWeb.getSettings().setJavaScriptEnabled(true);
            videoWeb.setWebChromeClient(new WebChromeClient() {
            } );
        }
    }
}
