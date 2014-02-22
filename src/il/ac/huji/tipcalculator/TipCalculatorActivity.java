package il.ac.huji.tipcalculator;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class TipCalculatorActivity extends Activity implements OnClickListener {
	EditText edtBillAmount;
	CheckBox chkRound;
	Button btnCalculate;
	TextView txtTipResult;
	double tipPercent = 0.12;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tip_calculator);
		
		edtBillAmount = (EditText)findViewById(R.id.edtBillAmount);
		chkRound = (CheckBox)findViewById(R.id.chkRound);
		btnCalculate = (Button)findViewById(R.id.btnCalculate);
		txtTipResult = (TextView)findViewById(R.id.txtTipResult);
		
		btnCalculate.setOnClickListener(this);
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tip_calculator, menu);
		return true;
	}

	@Override
	public void onClick(View arg0) {
		if(arg0.getId()==R.id.btnCalculate){
			calc();
		}
		
	}

	private void calc() {
		String text = edtBillAmount.getText().toString();
		if(isValidNum(text)){
			double val = Double.parseDouble(text);
			double tip = val*tipPercent;
			if(chkRound.isChecked()){
				tip = Math.round(tip);
			}
			txtTipResult.setText("Tip: $"+tip);
		}else{
			txtTipResult.setText("Please enter a valid number");
		}
		
		
	}

	private boolean isValidNum(String text) {
		return text.matches("[0-9]+|[0-9]+\\.[0-9]+");
		
		
	}

}
