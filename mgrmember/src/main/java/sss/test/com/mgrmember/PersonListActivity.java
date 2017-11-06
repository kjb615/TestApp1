package sss.test.com.mgrmember;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import sss.test.com.mgrmember.person.Person;
import sss.test.com.mgrmember.person.PersonContent;
import sss.test.com.mgrmember.recycler.SimpleItemRecyclerViewAdapter;

import java.util.List;

/**
 * An activity representing a list of Person. This activity
 * has different presentations for handset and tablet-size devices. On
 * handsets, the activity presents a list of items, which when touched,
 * lead to a {@link PersonDetailActivity} representing
 * item details. On tablets, the activity presents the list of items and
 * item details side-by-side using two vertical panes.
 */
public class PersonListActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener {

    /**
     * Whether or not the activity is in two-pane mode, i.e. running on a tablet
     * device.
     */
    private static int inTestCount = 0;
    private SwipeRefreshLayout swipeRefreshLayout;
    private SimpleItemRecyclerViewAdapter simpleItemRecyclerViewAdapter;
    private View recyclerView;
    private PersonContent personContent;
    private boolean mTwoPane;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_list);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle(getTitle());

        if (findViewById(R.id.person_detail_container) != null) {
            mTwoPane = true;
        }

        personContent = new PersonContent(this);
        personContent.searchAll();
        //simpleItemRecyclerViewAdapter = new SimpleItemRecyclerViewAdapter(this, mTwoPane);

        swipeRefreshLayout = (SwipeRefreshLayout)findViewById(R.id.person_list_swipe);
        swipeRefreshLayout.setOnRefreshListener(this);

        recyclerView = findViewById(R.id.person_list);
        assert recyclerView != null;
        setupRecyclerView((RecyclerView) recyclerView);

        createButtonAction();
    }


    private void setupRecyclerView(@NonNull RecyclerView recyclerView) {
        //simpleItemRecyclerViewAdapter = new SimpleItemRecyclerViewAdapter(this, personContent.ITEMS, mTwoPane);
        simpleItemRecyclerViewAdapter = new SimpleItemRecyclerViewAdapter(this, personContent, mTwoPane);
        recyclerView.setAdapter(simpleItemRecyclerViewAdapter);
    }

    @Override
    public void onRefresh() {
        //당겨서 새로고침 메서드
        //SwipeRefreshLayout
        //personContent.clearAll();
        //simpleItemRecyclerViewAdapter.refreshApply();
        //personContent.addAll();
        simpleItemRecyclerViewAdapter.refreshApply();
        setupRecyclerView((RecyclerView) recyclerView);
        try {
            swipeRefreshLayout.setColorSchemeResources(
                    android.R.color.holo_blue_bright,
                    android.R.color.holo_green_light,
                    android.R.color.holo_orange_light,
                    android.R.color.holo_red_light
            );

            Thread.sleep(4000);
        } catch (InterruptedException e) {
            //e.printStackTrace();
        }
        swipeRefreshLayout.setRefreshing(false);    //새로고침 아이콘 사라지게
    }

    public void createButtonAction() {
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                //        .setAction("Action", null).show();
                String s = String.valueOf(1000+inTestCount++);
                Person p = new Person();
                p.setIdx(s);
                p.setName("in_name_"+s);
                p.setAddr("in_addr_"+s);
                p.setId("in_id_"+s);
                personContent.insert(p);

                onRefresh();
                //personContent.removeAll();
            }
        });
    }


    /*
    public static class SimpleItemRecyclerViewAdapter
            extends RecyclerView.Adapter<SimpleItemRecyclerViewAdapter.ViewHolder> {

        private final PersonListActivity mParentActivity;
        private final List<Person> mValues;
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

        SimpleItemRecyclerViewAdapter(PersonListActivity parent,
                                      List<Person> items,
                                      boolean twoPane) {
            mValues = items;
            mParentActivity = parent;
            mTwoPane = twoPane;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.person_list_content, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(final ViewHolder holder, int position) {
            holder.mIdView.setText(mValues.get(position).getId());
            holder.mContentView.setText(mValues.get(position).getIdx());

            holder.itemView.setTag(mValues.get(position));
            holder.itemView.setOnClickListener(mOnClickListener);
        }

        @Override
        public int getItemCount() {
            return mValues.size();
        }

        class ViewHolder extends RecyclerView.ViewHolder {
            final TextView mIdView;
            final TextView mContentView;

            ViewHolder(View view) {
                super(view);
                mIdView = (TextView) view.findViewById(R.id.id_text);
                mContentView = (TextView) view.findViewById(R.id.content);
            }
        }
    }
    */
}
