package com.navigationhybrid.playground;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import com.navigationhybrid.NavigationFragment;

/**
 * Created by Listen on 2017/11/20.
 */

public class NativeResultFragment extends NavigationFragment {

    EditText resultText;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_native_result, container, false);

        resultText = view.findViewById(R.id.result);

        view.findViewById(R.id.send_result).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle result = new Bundle();
                result.putString("text", resultText.getText().toString());
                navigator.setResult(Activity.RESULT_OK, result);
                navigator.dismiss();
            }
        });

        view.findViewById(R.id.push_to_react).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigator.push("ReactResult");
            }
        });

        view.findViewById(R.id.push_to_native).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigator.push("NativeResult");
            }
        });

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setTitle("native result");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        hideSoftInput(resultText);
    }

    /**
     * 隐藏软键盘
     */
    public static void hideSoftInput(View view) {
        if (view == null || view.getContext() == null) return;
        InputMethodManager imm = (InputMethodManager) view.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

}
