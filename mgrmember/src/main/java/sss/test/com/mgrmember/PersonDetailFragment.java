package sss.test.com.mgrmember;

import android.app.Activity;
import android.support.design.widget.CollapsingToolbarLayout;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import sss.test.com.mgrmember.person.Person;
import sss.test.com.mgrmember.person.PersonContent;

/**
 * A fragment representing a single Person detail screen.
 * This fragment is either contained in a {@link PersonListActivity}
 * in two-pane mode (on tablets) or a {@link PersonDetailActivity}
 * on handsets.
 */
public class PersonDetailFragment extends Fragment {

    public static final String ARG_ITEM_ID = "item_id";
    private Person mItem;

    public PersonDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments().containsKey(ARG_ITEM_ID)) {
            mItem = PersonContent.ITEM_MAP.get(getArguments().getString(ARG_ITEM_ID));

            Activity activity = this.getActivity();
            CollapsingToolbarLayout appBarLayout = (CollapsingToolbarLayout) activity.findViewById(R.id.toolbar_layout);
            if (appBarLayout != null) {
                appBarLayout.setTitle(mItem.getName());
            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.person_detail, container, false);

        if (mItem != null) {
            TextView idx = (TextView)rootView.findViewById(R.id.detail_tv_idx);
            idx.setText(mItem.getIdx());
            TextView id = (TextView)rootView.findViewById(R.id.detail_tv_id);
            id.append(mItem.getId());
            TextView name = (TextView)rootView.findViewById(R.id.detail_tv_name);
            name.append(mItem.getName());
            //tv.append("\n이름 : ");
            //tv.append(mItem.getName());

        }

        return rootView;
    }
}
