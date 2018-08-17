package mx.utng.juniorsmed.appdaw;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

/**
 * Created by Alexa on 13/08/2018.
 */

public class FeedsAdapter extends RecyclerView.Adapter<FeedsAdapter.MyViewHolder> {
    ArrayList<FeedItem> feedItems;
    Context context;
    public FeedsAdapter(Context context, ArrayList<FeedItem>feedItems){
        this.feedItems=feedItems;
        this.context=context;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(mx.utng.juniorsmed.appdaw.R.layout.custom_row_news_item,parent,false);
        MyViewHolder holder=new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        YoYo.with(Techniques.FadeIn).playOn(holder.cardView);
        FeedItem current=feedItems.get(position);
        holder.Title.setText(Html.fromHtml(current.getTitle()));
        holder.Description.setText(Html.fromHtml(current.getDescription()));
        holder.Date.setText(current.getPubDate());


    }



    @Override
    public int getItemCount() {
        return feedItems.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView Title,Description,Date;
        CardView cardView;
        public MyViewHolder(View itemView) {
            super(itemView);
            Title= (TextView) itemView.findViewById(mx.utng.juniorsmed.appdaw.R.id.title_text);
            Description= (TextView) itemView.findViewById(mx.utng.juniorsmed.appdaw.R.id.description_text);
            Date= (TextView) itemView.findViewById(mx.utng.juniorsmed.appdaw.R.id.date_text);
            cardView= (CardView) itemView.findViewById(mx.utng.juniorsmed.appdaw.R.id.cardview);
        }
    }
}
