package com.sadek.ekatapp.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.sadek.ekatapp.R;
import com.sadek.ekatapp.adapter.NothingSelectedSpinnerAdapter;

import org.jetbrains.annotations.NotNull;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.bendik.simplerangeview.SimpleRangeView;

public class FilterDialogFragment extends BottomSheetDialogFragment {
    Unbinder unbinder;

    @BindView(R.id.filter_spinner)
    Spinner filter_spinner;
    @BindView(R.id.filter_max_txt)
    TextView filter_max_txt;
    @BindView(R.id.fixed_rangeview)
    SimpleRangeView fixed_rangeview;
    @BindView(R.id.filter_min_txt)
    TextView filter_min_txt;
    static FilterAction filterAction;

    public static FilterDialogFragment newInstance(FilterAction _filterAction) {
        filterAction = _filterAction;
        return new FilterDialogFragment();
    }

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_filter, container,
                false);
        unbinder = ButterKnife.bind(this, view);
        ArrayAdapter<CharSequence> adapterCountry = ArrayAdapter.createFromResource(getContext(), R.array.filter_array, android.R.layout.simple_spinner_item);
        adapterCountry.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        filter_spinner.setPrompt(getString(R.string.country));

        filter_spinner.setAdapter(
                new NothingSelectedSpinnerAdapter(
                        adapterCountry,
                        R.layout.filter_spinner_row_nothing_selected,
                        // R.layout.contact_spinner_nothing_selected_dropdown, // Optional
                        getContext()));
        initView();
        return view;
    }

    private void initView() {
        fixed_rangeview.setOnTrackRangeListener(new SimpleRangeView.OnTrackRangeListener() {
            @Override
            public void onStartRangeChanged(@NotNull SimpleRangeView rangeView, int start) {
                filter_min_txt.setText(String.valueOf(start)+" د.أ");

            }

            @Override
            public void onEndRangeChanged(@NotNull SimpleRangeView rangeView, int end) {

                filter_max_txt.setText(String.valueOf(end)+" د.أ9");
            }
        });

    }

    public interface FilterAction {
        void onGetFilterCode(String code);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        // unbind the view to free some memory
        unbinder.unbind();
    }
}
