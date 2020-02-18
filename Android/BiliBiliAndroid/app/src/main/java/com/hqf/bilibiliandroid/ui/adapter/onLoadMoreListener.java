package com.hqf.bilibiliandroid.ui.adapter;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public abstract class onLoadMoreListener extends RecyclerView.OnScrollListener {
    private int countItem;
    private int lastItem;
    private boolean isScrolled = false;//是否可以滑动
    private RecyclerView.LayoutManager layoutManager;

    /**
     * 加载回调方法
     * @param countItem 总数量
     * @param lastItem  最后显示的position
     */
    protected abstract void onLoading(int countItem, int lastItem);

    @Override
    public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
//        /* 测试这三个参数的作用 SCROLL_STATE_IDLE*/
//        if (newState==RecyclerView.SCROLL_STATE_IDLE){
//            Log.d("test","SCROLL_STATE_IDLE,空闲");
//        }
//        else if (newState==RecyclerView.SCROLL_STATE_DRAGGING){
//            Log.d("test","SCROLL_STATE_DRAGGING,拖拽");
//        }
//        else if (newState==RecyclerView.SCROLL_STATE_SETTLING){
//            Log.d("test","SCROLL_STATE_SETTLING,固定");
//        }
//        else{
//            Log.d("test","其它");
//        }
        //拖拽或者惯性滑动时isScrolled设置为true
        if (newState == RecyclerView.SCROLL_STATE_DRAGGING || newState == RecyclerView.SCROLL_STATE_SETTLING) {
            isScrolled = true;
        } else {
            isScrolled = false;
        }
    }

    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        if (recyclerView.getLayoutManager() instanceof LinearLayoutManager) {
            layoutManager = recyclerView.getLayoutManager();
            countItem = layoutManager.getItemCount();
            lastItem = ((LinearLayoutManager)layoutManager).findLastCompletelyVisibleItemPosition();
        }
        if (isScrolled && countItem != lastItem && lastItem == countItem - 1) {
            onLoading(countItem, lastItem);
        }
    }
}
