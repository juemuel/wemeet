package com.jue.meet.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jue.meet.model.StarModel;
import com.jue.framework.R;
import com.jue.framework.helper.GlideHelper;
import com.moxun.tagcloudlib.view.TagsAdapter;

import java.util.List;

/**
 * FileName: CloudTagAdapter
 * Founder: Jue
 * Profile: 3D星球适配器
 */
public class CloudTagAdapter extends TagsAdapter {

    private Context mContext;
    private List<StarModel> mList;
    private LayoutInflater inflater;

    public CloudTagAdapter(Context mContext, List<StarModel> mList) {
        this.mContext = mContext;
        this.mList = mList;
        inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    /**
     * 获取大小
     * @return
     */
    @Override
    public int getCount() {
        return mList.size();
    }

    /**
     * 【核心】获取星球View
     * @param context
     * @param position
     * @param parent
     * @return
     */
    @Override
    public View getView(Context context, int position, ViewGroup parent) {
        StarModel model = mList.get(position);
        //初始化View控件，用ViewHolder来获取控件的信息
        View mView = null;
        ViewHolder viewHolder = null;
        if (mView == null) {
            viewHolder = new ViewHolder();
            mView = inflater.inflate(R.layout.layout_star_view_item, null);
            viewHolder.iv_star_icon = mView.findViewById(R.id.iv_star_icon);
            viewHolder.tv_star_name = mView.findViewById(R.id.tv_star_name);
            mView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) mView.getTag();
        }
        if (!TextUtils.isEmpty(model.getPhotoUrl())) {
            GlideHelper.loadSmollUrl(mContext, model.getPhotoUrl(), 30, 30, viewHolder.iv_star_icon);
        } else {
            viewHolder.iv_star_icon.setImageResource(com.jue.meet.R.drawable.img_star_icon_3);
        }
        viewHolder.tv_star_name.setText(model.getNickName());
        return mView;//返回view
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public int getPopularity(int position) {
        return 7;
    }

    /**
     * 改变主题颜色（本项目不考虑哈）
     * @param view
     * @param themeColor
     */
    @Override
    public void onThemeColorChanged(View view, int themeColor) {

    }

    class ViewHolder {
        private ImageView iv_star_icon;
        private TextView tv_star_name;
    }
}
