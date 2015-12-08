package frenchdonuts.tasty.standard.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import frenchdonuts.tasty.standard.R;

/**
 * Created by pamelactan on 12/7/15.
 */
public class NameFragment extends Fragment {
    public final static String PAYLOAD = "name";

    public NameFragment() {}
    public static Fragment newInstance() {
        return new NameFragment();
    }

    TextView tvHelloName;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.name_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tvHelloName = (TextView) view.findViewById(R.id.tvHelloName);
    }

    @Override
    public void onStart() {
        super.onStart();
        Bundle args = getArguments();
        if (args != null) {
            String hello = getString(R.string.hello);
            tvHelloName.setText(hello + args.getString(PAYLOAD));
        }
    }
}
