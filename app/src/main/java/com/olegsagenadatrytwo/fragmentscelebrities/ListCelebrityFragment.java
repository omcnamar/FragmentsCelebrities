package com.olegsagenadatrytwo.fragmentscelebrities;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class ListCelebrityFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final String TAG = "ListCelebrityFragment";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private RecyclerView celebrityRecyclerView;
    private CelebrityAdapter celebrityAdapter;

    private OnFragmentInteractionListener mListener;

    public ListCelebrityFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ListCelebrityFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ListCelebrityFragment newInstance(String param1, String param2) {
        ListCelebrityFragment fragment = new ListCelebrityFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Log.d(TAG, "onCreateView: ");

        return inflater.inflate(R.layout.fragment_list_celebrity, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        celebrityRecyclerView = view.findViewById(R.id.celebrity_recycler_view);
        celebrityRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        Log.d(TAG, "onViewCreated: ");
        updateUI();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteractionList(Celebrity celebrity);
    }

    //this method updates the user interface if any changes were made
    private void updateUI() {
        List<Celebrity> celebrities = new ArrayList<>();
        Celebrity tomCruise = new Celebrity("Tom Cruize", "Actor", "07/03/1962", R.drawable.tom);
        Celebrity jessicaAlba = new Celebrity("Jessica Alba", "Actor", "04/28/1981", R.drawable.jessica);
        Celebrity shakira = new Celebrity("Shakira", "Singer", "02/02/1977", R.drawable.shakira);
        celebrities.add(tomCruise);
        celebrities.add(jessicaAlba);
        celebrities.add(shakira);
        if(celebrityAdapter == null) {
            celebrityAdapter = new CelebrityAdapter(celebrities);
            celebrityRecyclerView.setAdapter(celebrityAdapter);
        }else{
            //updated single item
            // mAdapter.notifyItemChanged(saved);
            //update multiple
            celebrityAdapter.setCelebrities(celebrities);
            celebrityAdapter.notifyDataSetChanged();
        }
        Log.d(TAG, "updateUI: ");

    }

    //Adapter
    private class CelebrityAdapter extends RecyclerView.Adapter<CelebrityHolder>{
        private List<Celebrity> celebrities;

        public CelebrityAdapter(List<Celebrity> celebrities){
            this.celebrities = celebrities;
        }

        @Override
        public CelebrityHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            Log.d(TAG, "onCreateViewHolder: ");
            View view = layoutInflater.inflate(R.layout.list_initial_info, parent, false);
            return new CelebrityHolder(view);
        }

        @Override
        public void onBindViewHolder(CelebrityHolder holder, int position) {
            Celebrity celebrity = celebrities.get(position);
            holder.bindContact(celebrity);
        }

        @Override
        public int getItemCount() {
            return celebrities.size();
        }

        public void setCelebrities(List<Celebrity> celebrities) {
            this.celebrities = celebrities;
        }
    }

    //holder
    //ViewHolder
    private class CelebrityHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private ImageView image;
        private TextView tvName;
        private Celebrity celebrity;

        public CelebrityHolder(View itemView){
            super(itemView);
            itemView.setOnClickListener(this);

            image = itemView.findViewById(R.id.ivImageInitial);
            tvName  = itemView.findViewById(R.id.tvNameInitial);
        }

        public void bindContact(Celebrity celebrityIn){
            celebrity = celebrityIn;
            tvName.setText(celebrityIn.getName());

            if(celebrityIn.getPic() != 0){
                image.setImageDrawable(ContextCompat.getDrawable(getActivity(), celebrity.getPic()));

            }
        }
        public void onClick(View v){
            Toast.makeText(getActivity(), "clicked", Toast.LENGTH_SHORT).show();
            mListener.onFragmentInteractionList(celebrity);
//            saved = getAdapterPosition();
//            Intent intent = ContactPagerActivity.newIntent(getApplicationContext(),contact.getId());
//            startActivity(intent);
        }
    }
}
