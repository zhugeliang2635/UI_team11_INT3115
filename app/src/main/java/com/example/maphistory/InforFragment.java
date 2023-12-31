package com.example.maphistory;

import android.app.Activity;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.maphistory.databinding.ActivityMainBinding;
import com.example.maphistory.databinding.FragmentInforBinding;

import java.util.ArrayList;
import java.util.Date;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link InforFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class InforFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private ListView listview2;
    MainActivity mainActivity;
    FragmentInforBinding binding;

    InforFragment i = new InforFragment();


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public InforFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment InforFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static InforFragment newInstance(String param1, String param2) {
        InforFragment fragment = new InforFragment();
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

//        Intent move = new Intent(context, ListActivity.class);
//        startActivity(move);

//        binding = FragmentInforBinding.inflate(getLayoutInflater());


//        int[] imgageId = {R.drawable.img_7, R.drawable.img_7,R.drawable.img_7,R.drawable.img_7,R.drawable.img_7, R.drawable.img_7,
//                R.drawable.img_7,R.drawable.img_7,R.drawable.img_7,R.drawable.img_7};
//        String[] name = {"Trận Bạch Đằng", "Trận Bạch Đằng", "Trận Bạch Đằng","Trận Bạch Đằng","Trận Bạch Đằng",
//                "Trận Bạch Đằng", "Trận Bạch Đằng","Trận Bạch Đằng","Trận Bạch Đằng","Trận Bạch Đằng"};
//        String[] time = {"Năm 938", "Năm 938","Năm 938","Năm 938","Năm 938","Năm 938","Năm 938",
//                "Năm 938","Năm 938","Năm 938",};
//
//        ArrayList<ListData> eventList = new ArrayList<>();
//
//        for (int i = 0; i < imgageId.length; i++) {
//            ListData listData = new ListData(name[i], time[i], imgageId[i], id);
//            eventList.add(listData);
//        }

//        ListAdapter listAdapter = new ListAdapter(getContext(), eventList);

//        binding.listview.setAdapter(listAdapter);
//        binding.listview.setClickable(true);
//        binding.listview.setOnItemClickListener(new AdapterView.OnItemClickListener(){
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
//
//            }
//        });




    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view1 = inflater.inflate(R.layout.activity_list, container, false);
        mainActivity = (MainActivity) getActivity();
        listview2 = view1.findViewById(R.id.listview2);
        int[] imgageId = {R.drawable.img_7, R.drawable.img_1,R.drawable.img_18, R.drawable.img_5, R.drawable.img_17,
                R.drawable.img_16,R.drawable.img_4,R.drawable.img_15,R.drawable.img_6, R.drawable.img_6};
        String[] name = {"Trận Bạch Đằng", "Trận Như Nguyệt", "Đông Bộ Đầu","Trận Chi Lăng","Trận Rạch Gầm",
                "Trận Ngọc Hồi", "Điện Biên Phủ","ĐBP trên không","Chiến dịch HCM", "Chiến dịch HCM"};
        String[] time = {"Năm 938", "Năm 1077","Năm 1258","Năm 1427","Năm 1785","Năm 1789",
                "Năm 1954","Năm 1972","Năm 1975", "Năm 1975"};
        String[] id = {"bachdang", "nhunguyet", "dongbodau","chilang","rachgam","ngochoi",
                "dienbienphu","dienbienphutrenkhong","chiendichHCM","chiendichHCM",};

        ArrayList<ListData> eventList = new ArrayList<>();

        for (int i = 0; i < imgageId.length; i++) {
            ListData listData = new ListData(name[i], time[i], imgageId[i], id[i]);
            eventList.add(listData);
        }
        ListAdapter listAdapter = new ListAdapter(mainActivity, eventList);



        listview2.setAdapter(listAdapter);
        listview2.setClickable(true);
        listview2.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                Log.d("TAG",Integer.toString(position) + " - " + Long.toString(id));
                Intent intent = new Intent(mainActivity, detail.class);
                intent.putExtra("event", eventList.get(position).getId());
                startActivity(intent);
            }
        });
        return view1;
    }
}