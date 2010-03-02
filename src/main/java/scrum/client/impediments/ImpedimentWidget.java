package scrum.client.impediments;

import ilarkesto.gwt.client.TableBuilder;
import ilarkesto.gwt.client.editor.DateEditorWidget;
import scrum.client.ScrumGwt;
import scrum.client.collaboration.CommentsWidget;
import scrum.client.common.AScrumWidget;

import com.google.gwt.user.client.ui.Widget;

public class ImpedimentWidget extends AScrumWidget {

	private Impediment impediment;

	public ImpedimentWidget(Impediment impediment) {
		super();
		this.impediment = impediment;
	}

	@Override
	protected Widget onInitialization() {
		TableBuilder tb = ScrumGwt.createFieldTable();
		tb.addFieldRow("Label", impediment.getLabelModel());
		tb.addFieldRow("Date", new DateEditorWidget(impediment.getDateModel()));
		tb.addFieldRow("Description", impediment.getDescriptionModel());
		tb.addFieldRow("Solution", impediment.getSolutionModel());
		tb.addFieldRow("My emoticon", impediment.createCurrentUserEmotionEditor());

		return TableBuilder.row(20, tb.createTable(), new CommentsWidget(impediment));
	}

}
