package com.example.newexpandablelistview.ExpandableLISTADAPTER;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.example.newexpandablelistview.R;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class ExpandableLIST extends BaseExpandableListAdapter {

    Context context;
    List<String> head_list_name;
    HashMap<String, List<String>> child_list_name;

    public ExpandableLIST(Context context, List<String> head_list_name, HashMap<String, List<String>> child_list_name) {
        this.context = context;
        this.head_list_name = head_list_name;
        this.child_list_name = child_list_name;
    }

    public ExpandableLIST() {
//        empty constructor
    }

    @Override
    public int getGroupCount() {
        return head_list_name.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return child_list_name.get(head_list_name.get(i)).size();
    }

    @Override
    public Object getGroup(int i) {
        return head_list_name.get(i);
    }

    @Override
    public Object getChild(int i, int i1) {
        return child_list_name.get(head_list_name.get(i)).get(i1);
    }

    @Override
    public long getGroupId(int i) {
        return 0;
    }

    @Override
    public long getChildId(int i, int i1) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {

        if (view == null) {
            LayoutInflater inflaterLayout = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflaterLayout.inflate(R.layout.expandable_header_sample_design, viewGroup, false);
        }
        TextView headTxt = view.findViewById(R.id.ex_header_txt);
        headTxt.setText(head_list_name.get(i));

        return view;
    }

    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
        if (view == null) {
            LayoutInflater inflaterLayout = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflaterLayout.inflate(R.layout.expandable_child_sample_design, viewGroup, false);
        }
        TextView childTXT = view.findViewById(R.id.ex_child_txt);
        childTXT.setText(child_list_name.get(head_list_name.get(i)).get(i1));

        return view;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }
}
