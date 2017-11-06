package sss.test.com.mgrmember.recycler;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import sss.test.com.mgrmember.PersonDetailActivity;
import sss.test.com.mgrmember.PersonDetailFragment;
import sss.test.com.mgrmember.PersonListActivity;
import sss.test.com.mgrmember.R;
import sss.test.com.mgrmember.person.Person;
import sss.test.com.mgrmember.person.PersonContent;

/**
 * Created by Administrator on 2017-11-06.
 */

public class SimpleItemRecyclerViewAdapter extends RecyclerView.Adapter<SimpleItemRecyclerViewAdapter.ViewHolder> {

    private final PersonListActivity mParentActivity;
    private final List<Person> mValues;
    private final PersonContent personContent;
    private final boolean mTwoPane;
    private final View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Person item = (Person) view.getTag();
            if (mTwoPane) {
                Bundle arguments = new Bundle();
                arguments.putString(PersonDetailFragment.ARG_ITEM_ID, item.getId());
                PersonDetailFragment fragment = new PersonDetailFragment();
                fragment.setArguments(arguments);
                mParentActivity.getSupportFragmentManager().beginTransaction()
                        .replace(R.id.person_detail_container, fragment)
                        .commit();
            } else {
                Context context = view.getContext();
                Intent intent = new Intent(context, PersonDetailActivity.class);
                intent.putExtra(PersonDetailFragment.ARG_ITEM_ID, item.getId());

                context.startActivity(intent);
            }
        }
    };

    public SimpleItemRecyclerViewAdapter(PersonListActivity parent,
                                         PersonContent data,
                                         boolean twoPane) {
        //personContent = new PersonContent(parent);
        personContent = data;
        mValues = PersonContent.ITEMS;
        mParentActivity = parent;
        mTwoPane = twoPane;
    }
/*

    public SimpleItemRecyclerViewAdapter(PersonListActivity parent,
                                         boolean twoPane) {
        //personContent = new PersonContent(parent);
        //personContent.searchAll();
        mValues = PersonContent.ITEMS;
        mParentActivity = parent;
        mTwoPane = twoPane;
    }

    public SimpleItemRecyclerViewAdapter(PersonListActivity parent,
                                         List<Person> items,
                                         boolean twoPane) {
        mValues = items;
        mParentActivity = parent;
        mTwoPane = twoPane;
    }
*/

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.person_list_content, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mIdxView.setText(mValues.get(position).getIdx());
        holder.midView.setText(mValues.get(position).getId());
        holder.mnameView.setText(mValues.get(position).getName());
        holder.maddrView.setText(mValues.get(position).getAddr());

        holder.itemView.setTag(mValues.get(position));
        holder.itemView.setOnClickListener(mOnClickListener);
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    //리스트에 보여질 내용
    class ViewHolder extends RecyclerView.ViewHolder {
        final TextView mIdxView;
        final TextView midView;
        final TextView mnameView;
        final TextView maddrView;


        ViewHolder(View view) {
            super(view);
            mIdxView = (TextView) view.findViewById(R.id.person_list_content_tv_idx);
            midView = (TextView) view.findViewById(R.id.person_list_content_tv_id);
            mnameView = (TextView) view.findViewById(R.id.person_list_content_tv_name);
            maddrView = (TextView) view.findViewById(R.id.person_list_content_tv_addr);
        }
    }

    //새로고침
    public void refreshApply() {
        personContent.clearAll();
        //PersonContent.clearAll();
        notifyDataSetChanged();
        //mValues.addAll(personContent.ITEMS);
        personContent.searchAll();
        //PersonContent.searchAll();
        notifyDataSetChanged();
    }

}