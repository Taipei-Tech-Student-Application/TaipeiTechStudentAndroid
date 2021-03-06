package com.Ntut.other;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.Ntut.MainActivity;
import com.Ntut.R;
import com.Ntut.about.AboutActivity;
import com.Ntut.account.AccountActivity;
import com.Ntut.credit.CreditActivity;
import com.Ntut.etc.EtcActivity;
import com.Ntut.feedback.FeedbackActivity;
import com.Ntut.schoolmap.MapActivity;
import com.Ntut.model.OtherInfo;
import com.Ntut.store.StoreActivity;

import java.util.List;

/**
 * Created by blackmaple on 2017/5/14.
 */

public class OtherAdapter extends RecyclerView.Adapter<OtherAdapter.ViewHolder> {

    private List<OtherInfo> otherInfos;
    private MainActivity context;
    private final static int CREDIT_ID = 0;
    private final static int ACCOUNT_ID = 1;
    private final static int MAP_ID = 2;
    private final static int STORE_ID = 3;
    private final static int FEEDBACK_ID = 4;
    private final static int ETC_ID = 5;
    private final static int ABOUT_ID = 6;


    public OtherAdapter(List<OtherInfo> otherInfos, Context context){
        this.otherInfos = otherInfos;
        this.context = (MainActivity) context;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView otherText;
        public ImageView imageView;
        public  ViewHolderOnClick listener;
        public ViewHolder(View itemView, ViewHolderOnClick listener){
            super(itemView);
            otherText = itemView.findViewById(R.id.other_text);
            imageView = itemView.findViewById(R.id.other_image);
            this.listener = listener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            listener.onClick(v, getLayoutPosition());
        }

        public interface ViewHolderOnClick{
            void onClick(View v, int position);
        }
    }

    @Override
    public OtherAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View contactView = LayoutInflater.from(context).inflate(R.layout.other_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(contactView, (v, position) -> {
            Intent intent;
            switch (position){
                case CREDIT_ID:
                    intent = new Intent(context, CreditActivity.class);
                    context.startActivity(intent);
                    break;
                case ACCOUNT_ID:
                    intent = new Intent(context, AccountActivity.class);
                    context.startActivity(intent);
                    break;
                case MAP_ID:
                    intent = new Intent(context, MapActivity.class);
                    context.startActivity(intent);
                    break;
                case STORE_ID:
                    intent = new Intent(context, StoreActivity.class);
                    context.startActivity(intent);
                    break;
                case FEEDBACK_ID:
                    intent = new Intent(context, FeedbackActivity.class);
                    context.startActivity(intent);
                    break;
                case ETC_ID:
                    intent = new Intent(context, EtcActivity.class);
                    context.startActivity(intent);
                    break;
                case ABOUT_ID:
                    intent = new Intent(context, AboutActivity.class);
                    context.startActivity(intent);
            }
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(OtherAdapter.ViewHolder holder, int position) {
        OtherInfo otherInfo = this.otherInfos.get(position);
        TextView otherText = holder.otherText;
        otherText.setText(otherInfo.getTitle());
        ImageView imageView = holder.imageView;
        imageView.setImageResource(otherInfo.getIconId());
    }

    @Override
    public int getItemCount() {
        return otherInfos.size();
    }


}
