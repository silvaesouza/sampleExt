package br.com.silvaesouza.sampleext.client.ui;

public class PessoaView {
	
	public PessoaView() {
		// TODO Auto-generated constructor stub
	}
	
	/*
	private PersonApplicationAsync app = GWT.create(PersonApplication.class);
	
	private TextField<String> fieldName = new TextField<String>();
	private TextField<String> fieldEmail = new TextField<String>();
	private TextField<String> fieldPhone = new TextField<String>();
	private TextField<String> fieldCell = new TextField<String>();
	
	private PersonG person;
	
	private Button btSave = new Button("Salvar");
	
	private FormPanel fp = new FormPanel();
	
	public PessoaView() {
		setHeading("Incluir Pessoa");
		setMinimizable(false);
		setSize(350, 175);
		configure();
		configureBtSave();
	}
	
	private void configure(){
		fp.setHeaderVisible(false);
		fieldName.setFieldLabel("Nome");
		fp.add(fieldName);
		
		fieldEmail.setFieldLabel("Email");
		fp.add(fieldEmail);
		
		fieldPhone.setFieldLabel("Fixo");
		fp.add(fieldPhone);
		
		fieldCell.setFieldLabel("Celular");
		fp.add(fieldCell);
		add(fp);
		
		fp.add(btSave);
		add(fp);
		layout();
	}
	
	private PersonG getPerson(){
		person = new PersonG();
		
		person.setName(fieldName.getValue());
		person.setEmail(fieldEmail.getValue());
		person.setPhone(fieldPhone.getValue());
		person.setCell(fieldCell.getValue());
		return person;
	}
	
	private void configureBtSave(){
		btSave.addListener(Events.OnClick, new Listener<ButtonEvent>() {

			@Override
			public void handleEvent(ButtonEvent be) {
				app.save(getPerson(), new AsyncCallback<Void>() {
					
					@Override
					public void onSuccess(Void result) {
						Info.display("Sucesso","");
					}
					
					@Override
					public void onFailure(Throwable caught) {
						Info.display("Falha","");
					}
				});
			}
		});
	}*/
}