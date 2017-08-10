package com.olegsagenadatrytwo.fragmentscelebrities;

import android.app.FragmentTransaction;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements ListCelebrityFragment.OnFragmentInteractionListener,
        CelebrityDetailFragment.OnFragmentInteractionListener{

    private static final String TAG = "MainActivity";
    private static final String LIST_CELEBRITY = "ListCelebrityFragment";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        ListCelebrityFragment listceleb = new ListCelebrityFragment();
//        getSupportFragmentManager().beginTransaction()
//                .addToBackStack("assdff").replace(R.id.frame, listceleb).commit();

        // if savedInstanceState is null we do some cleanup
//        if (savedInstanceState != null) {
//            // cleanup any existing fragments in case we are in detailed mode
//            getFragmentManager().executePendingTransactions();
//            Fragment fragmentById = getFragmentManager().
//                    findFragmentById(R.id.frame);
//            if (fragmentById!=null) {
//                getFragmentManager().beginTransaction()
//                        .remove(fragmentById).commit();
//            }
//        }
//        ListCelebrityFragment listFragment = new ListCelebrityFragment();
//        getFragmentManager().beginTransaction()
//                .replace(R.id.frame, listFragment, "BasicList").commit();
//        Log.d(TAG, "onCreate: ");
    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    public void onFragmentInteractionList(Celebrity celebrity) {


        CelebrityDetailFragment newFragment = new CelebrityDetailFragment();
        Bundle args = new Bundle();
        args.putSerializable("celebrity", celebrity);
        newFragment.setArguments(args);
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        // Replace whatever is in the fragment_container view with this fragment,
        // and add the transaction to the back stack so the user can navigate back
        transaction.replace(R.id.frame, newFragment);
        transaction.addToBackStack("asdf");
        // Commit the transaction
        transaction.commit();
    }

    @Override
    public void onFragmentInteractionDetail(Uri uri) {



    }
}
