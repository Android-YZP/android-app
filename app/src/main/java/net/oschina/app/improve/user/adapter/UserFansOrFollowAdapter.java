package net.oschina.app.improve.user.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;

import net.oschina.app.R;
import net.oschina.app.improve.base.adapter.BaseRecyclerAdapter;
import net.oschina.app.improve.user.bean.UserFansOrFollows;
import net.oschina.app.util.ImageLoader;

import butterknife.Bind;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by fei on 2016/8/24.
 * desc:
 */

public class UserFansOrFollowAdapter extends BaseRecyclerAdapter<UserFansOrFollows> {

    //private static final String TAG = "UserFansOrFollowAdapter";
    private RequestManager requestManager;

    public UserFansOrFollowAdapter(Context context, int mode) {
        super(context, mode);
        requestManager = Glide.with(context);
    }

    @Override
    protected RecyclerView.ViewHolder onCreateDefaultViewHolder(ViewGroup parent, int type) {
        return new UserFansViewHolder(mInflater.inflate(R.layout.activity_item_user_flow, parent, false));
    }

    @Override
    protected void onBindDefaultViewHolder(RecyclerView.ViewHolder holder, UserFansOrFollows item, int position) {

        if (item == null) return;
        final UserFansViewHolder vh = (UserFansViewHolder) holder;
        ImageLoader.loadImage(requestManager, vh.mCiIcon, item.getPortrait(), R.mipmap.widget_default_face);
        vh.mTvName.setText(item.getName());
        switch (item.getGender()) {
            case 0:
                vh.mIvSex.setVisibility(View.GONE);
                break;
            case 1:
                vh.mIvSex.setVisibility(View.VISIBLE);
                vh.mIvSex.setImageResource(R.mipmap.userinfo_icon_male);
                break;
            case 2:
                vh.mIvSex.setVisibility(View.VISIBLE);
                vh.mIvSex.setImageResource(R.mipmap.userinfo_icon_female);
                break;
            default:
                break;
        }
        vh.mTvDesc.setText(item.getDesc());
        UserFansOrFollows.More more = item.getMore();
        if (more == null) return;
        vh.mTvCity.setText(more.getCity());
        vh.mTvExp.setText(more.getExpertise());

    }

    @Override
    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        super.setOnItemClickListener(onItemClickListener);
    }

    /**
     *
     */
    class UserFansViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.iv_user_flow_icon)
        CircleImageView mCiIcon;
        @Bind(R.id.tv_user_flow_name)
        TextView mTvName;
        @Bind(R.id.iv_user_flow_sex)
        ImageView mIvSex;
        @Bind(R.id.tv_user_flow_city)
        TextView mTvCity;
        @Bind(R.id.tv_user_flow_desc)
        TextView mTvDesc;
        @Bind(R.id.tv_user_flow_expertise)
        TextView mTvExp;


        UserFansViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
