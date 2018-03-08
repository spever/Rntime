package com.redluo.rntime.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.SpannableString;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.redluo.rntime.R;
import com.redluo.rntime.commonUtil.UIUtil;

/**
 * Created by luo
 * on 2018/2/2
 * in Rntime
 */

public class commonItem extends LinearLayout {

    private Context context;
    private int iconID;
    private String title;
    private ImageView iv_icon;
    private TextView tv_title;
    private TextView tv_tip;
    private View divider_top;
    private View divider_bottom;
    private float leftTitltSize;
    private float rightTitltSize;
    private boolean leftIconVisble;
    private View divider_line;
    private String hintText;
    private boolean rightTextViewVisble;

    public commonItem(Context context) {
        this(context, null, 0);
    }

    public commonItem(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public commonItem(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        init(attrs, defStyleAttr);
    }

    private void init(AttributeSet attrs, int defStyleAttr) {
        View view = View.inflate(context, R.layout.common_item, null);
        iv_icon = (ImageView) view.findViewById(R.id.iv_icon);
        tv_title = (TextView) view.findViewById(R.id.tv_title);
        tv_tip = (TextView) view.findViewById(R.id.tv_tip);
        divider_top = view.findViewById(R.id.divider_top);
        divider_bottom = view.findViewById(R.id.divider_bottom);
        divider_line = view.findViewById(R.id.view_line);
        LayoutParams layoutParams = new LayoutParams(LayoutParams.MATCH_PARENT, UIUtil.dip2px(50));
        this.addView(view, layoutParams);
        final TypedArray a = getContext().obtainStyledAttributes(attrs,
                R.styleable.commonItem, defStyleAttr, 0);
        initAttributes(a);
        a.recycle();
        setIconResourceId(iconID, leftIconVisble);
        setTitle(title);
        setRightView(rightTextViewVisble);
        setHintText(hintText);
        setTitleSize(leftTitltSize, rightTitltSize);
        invalidate();
    }


    private void initAttributes(TypedArray a) {
        iconID = a.getResourceId(R.styleable.commonItem_icon_src, R.drawable.ic_launcher);
        title = a.getString(R.styleable.commonItem_title_text);
        leftTitltSize = a.getDimension(R.styleable.commonItem_leftTitleSize, 17);
        rightTitltSize = a.getDimension(R.styleable.commonItem_RightTitleSize, 16);
        rightTextViewVisble = a.getBoolean(R.styleable.commonItem_RightTextViewVisible, false);
        leftIconVisble = a.getBoolean(R.styleable.commonItem_leftIconVisble, false);
        hintText = a.getString(R.styleable.commonItem_hintText);
    }

    /**
     * 设置条目标题
     */
    public void setTitle(String title) {
        tv_title.setText(title);

    }

    private void setRightView(boolean rightTextViewVisble) {

        tv_tip.setVisibility(rightTextViewVisble ? VISIBLE : GONE);

    }


    public void setTitleSize(float leftTitltSize, float rightTitleSize) {
        if (leftTitltSize != 17)
            tv_title.setTextSize(TypedValue.COMPLEX_UNIT_PX, leftTitltSize);
        if (rightTitleSize != 16) {
            tv_tip.setTextSize(TypedValue.COMPLEX_UNIT_PX, rightTitleSize);
        }
    }

    /**
     * 设置条目左侧图标
     */
    public void setIconResourceId(int iconID, boolean leftIconVisble) {
        iv_icon.setImageResource(iconID);
        iv_icon.setVisibility(leftIconVisble ? VISIBLE : GONE);
    }

    private void setHintText(String hintText) {
        if (!TextUtils.isEmpty(hintText))
            tv_tip.setHint(hintText);
    }

    /**
     * 设置条目右侧提示文字
     */
    public void setTipWithoutRedPoint(SpannableString string) {
        tv_tip.setVisibility(VISIBLE);
        tv_tip.setText(string);
    }



    public void setCountText(String pattern, String count) {
        if (!TextUtils.isEmpty(count)) {
            tv_tip.setVisibility(VISIBLE);
            tv_tip.setText(pattern + count);
//            Drawable hongdian = getResources().getDrawable(R.drawable.hongdian);
//            tv_tip.setCompoundDrawablesWithIntrinsicBounds(hongdian,null,null,null);
//            tv_tip.setCompoundDrawablePadding(UIUtil.dip2px(6));
        } else {
            tv_tip.setVisibility(GONE);
        }
    }


    /**
     * 设置条目右侧提示文字可见性
     */
    public void setTipVisibility(int visibleState) {
        tv_tip.setVisibility(visibleState);
    }

    /**
     * 设置上下分割线可见状态
     *
     * @param top    true 上分割线可见 false 上分割线隐藏
     * @param bottom true 下分割线可见 false 下分割线隐藏
     */
    public void setDividerVisibleState(boolean top, boolean bottom) {
        if (top) {
            divider_top.setVisibility(VISIBLE);
        } else {
            divider_top.setVisibility(INVISIBLE);
        }
        if (bottom) {
            divider_bottom.setVisibility(VISIBLE);
        } else {
            divider_bottom.setVisibility(INVISIBLE);
        }
    }

    public void setDividerLineVisibleState(boolean visibleState) {
        if (visibleState) {
            divider_line.setVisibility(VISIBLE);
        } else {
            divider_line.setVisibility(GONE);
        }

    }
}
