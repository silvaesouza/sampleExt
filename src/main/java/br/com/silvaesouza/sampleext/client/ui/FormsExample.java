package br.com.silvaesouza.sampleext.client.ui;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.i18n.client.DateTimeFormat.PredefinedFormat;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.sencha.gxt.cell.core.client.form.ComboBoxCell.TriggerAction;
import com.sencha.gxt.core.client.util.DateWrapper;
import com.sencha.gxt.core.client.util.ToggleGroup;
import com.sencha.gxt.data.shared.ListStore;
import com.sencha.gxt.widget.core.client.FramedPanel;
import com.sencha.gxt.widget.core.client.Slider;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.container.BoxLayoutContainer.BoxLayoutData;
import com.sencha.gxt.widget.core.client.container.MarginData;
import com.sencha.gxt.widget.core.client.container.VBoxLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VBoxLayoutContainer.VBoxLayoutAlign;
import com.sencha.gxt.widget.core.client.event.ParseErrorEvent;
import com.sencha.gxt.widget.core.client.event.ParseErrorEvent.ParseErrorHandler;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.event.SelectEvent.SelectHandler;
import com.sencha.gxt.widget.core.client.form.CheckBox;
import com.sencha.gxt.widget.core.client.form.ComboBox;
import com.sencha.gxt.widget.core.client.form.DateField;
import com.sencha.gxt.widget.core.client.form.DoubleSpinnerField;
import com.sencha.gxt.widget.core.client.form.FieldLabel;
import com.sencha.gxt.widget.core.client.form.FieldSet;
import com.sencha.gxt.widget.core.client.form.IntegerField;
import com.sencha.gxt.widget.core.client.form.PasswordField;
import com.sencha.gxt.widget.core.client.form.Radio;
import com.sencha.gxt.widget.core.client.form.TextArea;
import com.sencha.gxt.widget.core.client.form.TextField;
import com.sencha.gxt.widget.core.client.form.TimeField;
import com.sencha.gxt.widget.core.client.form.validator.MinDateValidator;
import com.sencha.gxt.widget.core.client.form.validator.MinLengthValidator;
import com.sencha.gxt.widget.core.client.info.Info;

import br.com.silvaesouza.sampleext.client.model.Stock;
import br.com.silvaesouza.sampleext.client.model.StockProperties;
import br.com.silvaesouza.sampleext.client.service.FormExampleService;
import br.com.silvaesouza.sampleext.client.service.FormExampleServiceAsync;
import br.com.silvaesouza.sampleext.client.util.TestData;
import br.com.silvaesouza.sampleext.client.vo.FormExampleVO;

public class FormsExample extends Composite {

	protected static final int MIN_HEIGHT = 940;
	protected static final int MIN_WIDTH = 360;

	private FormExampleServiceAsync serviceStock = GWT.create(FormExampleService.class);

	TextField firstName;
	ComboBox<Stock> comboCompany;
	TextField email;
	PasswordField password;
	IntegerField age;
	DateField dateBirthday;
	TimeField time;
	Slider sliderSize;
	CheckBox checkMusicClassical;
	CheckBox checkMusicRock;
	CheckBox checkMusicBlues;
	Radio radioColorRed;
	Radio radioColorBlue;
	TextArea description;
	final DoubleSpinnerField spinnerField = new DoubleSpinnerField();
  
	private FormExampleVO getForm() {
		String company = comboCompany.getCurrentValue() != null ? comboCompany.getCurrentValue().getName() : null;

		FormExampleVO exampleVO = new FormExampleVO();
		exampleVO.setName(firstName.getCurrentValue());
		exampleVO.setEmail(email.getCurrentValue());
		exampleVO.setPassword(password.getCurrentValue());
		exampleVO.setAge(age.getCurrentValue());
		exampleVO.setCompany(company);
		exampleVO.setBirthday(dateBirthday.getCurrentValue());
		exampleVO.setTime(time.getCurrentValue());
		exampleVO.setSize(sliderSize.getValue());
		List<String> musics = new ArrayList<String>();
		if (checkMusicClassical.getValue())
			musics.add(checkMusicClassical.getBoxLabel().asString());
		if (checkMusicRock.getValue())
			musics.add(checkMusicRock.getBoxLabel().asString());
		if (checkMusicBlues.getValue())
			musics.add(checkMusicBlues.getBoxLabel().asString());
		exampleVO.setMusic(musics);
		if (radioColorBlue.getValue()) {
			exampleVO.setColor(radioColorBlue.getBoxLabel().asString());
		} else if(radioColorRed.getValue()) {
			exampleVO.setColor(radioColorRed.getBoxLabel().asString());
		}
		exampleVO.setDescription(description.getCurrentValue());
		exampleVO.setDuration(spinnerField.getCurrentValue());

		return exampleVO;
	}
  
	public FormsExample() {
		FramedPanel panel1 = createForm1();
		initWidget(panel1);
	}

	private FramedPanel createForm1() {
		firstName = new TextField();
		firstName.setAllowBlank(false);
		firstName.setEmptyText("Enter your name...");
		firstName.addValueChangeHandler(new ValueChangeHandler<String>() {
			@Override
			public void onValueChange(ValueChangeEvent<String> event) {
				Info.display("Value Changed",
						"First name changed to " + event.getValue() == null ? "blank" : event.getValue());
			}
		});

		email = new TextField();
		email.setAllowBlank(false);

		password = new PasswordField();

		age = new IntegerField();
		age.setAllowBlank(false);
		age.addParseErrorHandler(new ParseErrorHandler() {
			@Override
			public void onParseError(ParseErrorEvent event) {
				Info.display("Parse Error", event.getErrorValue() + " could not be parsed as a number");
			}
		});

		StockProperties properties = GWT.create(StockProperties.class);

		ListStore<Stock> store = new ListStore<Stock>(properties.key());
		store.addAll(TestData.getStocks());

		comboCompany = new ComboBox<Stock>(store, properties.nameLabel());
		comboCompany.setAllowBlank(true);
		comboCompany.setForceSelection(true);
		comboCompany.setTriggerAction(TriggerAction.ALL);
		comboCompany.addValueChangeHandler(new ValueChangeHandler<Stock>() {
			@Override
			public void onValueChange(ValueChangeEvent<Stock> event) {
				Info.display("Selected", "You selected " + event.getValue());
			}
		});

		dateBirthday = new DateField();
		dateBirthday.addValidator(new MinDateValidator(new Date()));
		dateBirthday.addParseErrorHandler(new ParseErrorHandler() {
			@Override
			public void onParseError(ParseErrorEvent event) {
				Info.display("Parse Error", event.getErrorValue() + " could not be parsed as a date");
			}
		});
		dateBirthday.addValueChangeHandler(new ValueChangeHandler<Date>() {
			@Override
			public void onValueChange(ValueChangeEvent<Date> event) {
				String v = event.getValue() == null ? "nothing"
						: DateTimeFormat.getFormat(PredefinedFormat.DATE_MEDIUM).format(event.getValue());
				Info.display("Selected", "You selected " + v);
			}
		});
		dateBirthday.setAutoValidate(true);

		time = new TimeField();
		time.setTriggerAction(TriggerAction.ALL);
		time.setFormat(DateTimeFormat.getFormat("hh:mm a"));
		time.setMinValue(new DateWrapper().clearTime().addHours(8).asDate());
		time.setMaxValue(new DateWrapper().clearTime().addHours(18).addSeconds(1).asDate());
		time.addParseErrorHandler(new ParseErrorHandler() {
			@Override
			public void onParseError(ParseErrorEvent event) {
				Info.display("Parse Error", event.getErrorValue() + " could not be parsed as a valid time");
			}
		});

		sliderSize = new Slider();
		sliderSize.setMinValue(40);
		sliderSize.setMaxValue(90);
		sliderSize.setValue(0);
		sliderSize.setIncrement(5);
		sliderSize.setMessage("{0} inches tall");

		ValueChangeHandler<Boolean> musicHandler = new ValueChangeHandler<Boolean>() {
			@Override
			public void onValueChange(ValueChangeEvent<Boolean> event) {
				CheckBox check = (CheckBox) event.getSource();
				Info.display("Music Changed",
						check.getBoxLabel() + " " + (event.getValue() ? "selected" : "not selected"));
			}
		};

		checkMusicClassical = new CheckBox();
		checkMusicClassical.setEnabled(false);
		checkMusicClassical.setBoxLabel("Classical");
		checkMusicClassical.addValueChangeHandler(musicHandler);

		checkMusicRock = new CheckBox();
		checkMusicRock.setBoxLabel("Rock");
		checkMusicRock.addValueChangeHandler(musicHandler);
		checkMusicRock.setValue(true);

		checkMusicBlues = new CheckBox();
		checkMusicBlues.setBoxLabel("Blues");
		checkMusicBlues.addValueChangeHandler(musicHandler);

		radioColorRed = new Radio();
		radioColorRed.setBoxLabel("Red");

		radioColorBlue = new Radio();
		radioColorBlue.setBoxLabel("Blue");
		radioColorBlue.setValue(true);

		// we can set name on radios or use toggle group
		ToggleGroup toggle = new ToggleGroup();
		toggle.add(radioColorRed);
		toggle.add(radioColorBlue);
		toggle.addValueChangeHandler(new ValueChangeHandler<HasValue<Boolean>>() {
			@Override
			public void onValueChange(ValueChangeEvent<HasValue<Boolean>> event) {
				ToggleGroup group = (ToggleGroup) event.getSource();
				Radio radio = (Radio) group.getValue();
				Info.display("Color Changed", "You selected " + radio.getBoxLabel());
			}
		});

		description = new TextArea();
		description.setHeight(100);
		description.setAllowBlank(false);
		description.addValidator(new MinLengthValidator(10));

		spinnerField.setIncrement(.1d);
		spinnerField.setMinValue(-10d);
		spinnerField.setMaxValue(10d);
		spinnerField.setAllowNegative(true);
		spinnerField.setAllowBlank(false);
		spinnerField.getPropertyEditor().setFormat(NumberFormat.getFormat("0.0"));
		spinnerField.addValueChangeHandler(new ValueChangeHandler<Double>() {
			@Override
			public void onValueChange(ValueChangeEvent<Double> event) {
				Info.display("Duration Changed",
						"Duration changed to " + event.getValue() == null ? "nothing" : event.getValue() + "");
			}
		});
		spinnerField.addSelectionHandler(new SelectionHandler<Double>() {
			@Override
			public void onSelection(SelectionEvent<Double> event) {
				String msg = "nothing";
				if (event.getSelectedItem() != null) {
					msg = spinnerField.getPropertyEditor().render(event.getSelectedItem());
				}

				Info.display("Spin Change", "Current value changed to " + msg);
			}
		});

		FieldLabel spinLabel = new FieldLabel(spinnerField, "Duration(s)");

		HorizontalPanel hp1 = new HorizontalPanel();
		hp1.add(checkMusicClassical);
		hp1.add(checkMusicRock);
		hp1.add(checkMusicBlues);

		HorizontalPanel hp2 = new HorizontalPanel();
		hp2.add(radioColorRed);
		hp2.add(radioColorBlue);

		BoxLayoutData nostretch = new BoxLayoutData();
		nostretch.setMaxSize(-1);

		BoxLayoutData flex = new BoxLayoutData();
		flex.setFlex(1);

		VBoxLayoutContainer vlc = new VBoxLayoutContainer(VBoxLayoutAlign.STRETCH);
		vlc.add(new FieldLabel(firstName, "Name"));
		vlc.add(new FieldLabel(email, "Email"));
		vlc.add(new FieldLabel(password, "Password"));
		vlc.add(new FieldLabel(age, "Age"));
		vlc.add(new FieldLabel(comboCompany, "Company"));
		vlc.add(new FieldLabel(dateBirthday, "Birthday"));
		vlc.add(new FieldLabel(time, "Time"));
		vlc.add(new FieldLabel(sliderSize, "Size"));
		vlc.add(new FieldLabel(hp1, "Music"), nostretch);
		vlc.add(new FieldLabel(hp2, "Color"), nostretch);
		vlc.add(new FieldLabel(description, "Description"), flex);
		vlc.add(spinLabel);

		FramedPanel panel = new FramedPanel();
		panel.setHeading("Forms Example - Simple");
		panel.add(vlc, new MarginData(15, 15, 0, 15));
		TextButton buttonSave = new TextButton("Save");
		
		buttonSave.addSelectHandler(new SelectHandler() {
			@Override
			public void onSelect(SelectEvent event) {
				serviceStock.save(getForm(), new AsyncCallback<String>() {
					
					@Override
					public void onSuccess(String result) {
						Info.display(result, "");
					}
					
					@Override
					public void onFailure(Throwable caught) {
						Info.display(caught.getMessage(), "");
					}
				});
			}
		});
		
		panel.addButton(buttonSave);
		panel.addButton(new TextButton("Cancel"));

		return panel;
	}
	
	

	private FramedPanel createForm2() {
		TextField firstName = new TextField();
		firstName.setAllowBlank(false);

		TextField lastName = new TextField();
		lastName.setAllowBlank(false);

		TextField email = new TextField();
		email.setAllowBlank(false);

		VBoxLayoutContainer vlc = new VBoxLayoutContainer(VBoxLayoutAlign.STRETCH);
		vlc.add(new FieldLabel(firstName, "First Name"));
		vlc.add(new FieldLabel(lastName, "Last Name"));
		vlc.add(new FieldLabel(email, "Email"));

		FieldSet fieldSet = new FieldSet();
		fieldSet.setHeading("User Information");
		fieldSet.setCollapsible(true);
		fieldSet.add(vlc);

		FramedPanel form2 = new FramedPanel();
		form2.setHeading("Forms Example - FieldSet");
		form2.add(fieldSet, new MarginData(15));
		form2.addButton(new TextButton("Save"));
		form2.addButton(new TextButton("Cancel"));

		return form2;
	}

}