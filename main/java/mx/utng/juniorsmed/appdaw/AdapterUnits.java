package mx.utng.juniorsmed.appdaw;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Alexa on 05/07/2018.
 */

public class AdapterUnits extends RecyclerView.Adapter<AdapterUnits.ThemesViewHolder> implements View.OnClickListener {
    ArrayList<ThemesUnits> listThemes;
    private View.OnClickListener listener;

    public AdapterUnits(ArrayList<ThemesUnits> listThemes) {
        this.listThemes = listThemes;

    }

    public ThemesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(mx.utng.juniorsmed.appdaw.R.layout.item_list, null, false);
        RecyclerView.LayoutParams layParams = new RecyclerView.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        view.setLayoutParams(layParams);

        view.setOnClickListener(this);

        return new ThemesViewHolder(view);
    }

    public void onBindViewHolder(ThemesViewHolder holder, int position) {
        holder.txtNameTheme.setText(listThemes.get(position).getNameTheme());
        if (UtilitiesUnits.PORTRAIT == true) {
            holder.txtInformationTheme.setText(listThemes.get(position).getInfoTheme());
        }
        holder.imgTheme.setImageResource(listThemes.get(position).getImageThema());
    }

    @Override
    public int getItemCount() {
        return listThemes.size();
    }

    public void setOnClickListener(View.OnClickListener listener) {
        this.listener = listener;
    }

    @Override
    public void onClick(View view) {
        if (listener != null) {
            listener.onClick(view);
        }

    }

    public class ThemesViewHolder extends RecyclerView.ViewHolder {
        TextView txtNameTheme, txtInformationTheme;
        ImageView imgTheme;

        public ThemesViewHolder(View itemView) {
            super(itemView);
            txtNameTheme = (TextView) itemView.findViewById(mx.utng.juniorsmed.appdaw.R.id.txt_name_theme);
            if (UtilitiesUnits.PORTRAIT == true) {
                txtInformationTheme = (TextView) itemView.findViewById(mx.utng.juniorsmed.appdaw.R.id.txt_info_theme);
            }

            imgTheme = (ImageView) itemView.findViewById(mx.utng.juniorsmed.appdaw.R.id.img_theme);
        }

    }
}


