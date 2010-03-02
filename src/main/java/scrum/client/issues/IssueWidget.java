package scrum.client.issues;

import ilarkesto.gwt.client.TableBuilder;
import scrum.client.ScrumGwt;
import scrum.client.collaboration.CommentsWidget;
import scrum.client.common.AScrumWidget;

import com.google.gwt.user.client.ui.Widget;

public class IssueWidget extends AScrumWidget {

	private Issue issue;

	public IssueWidget(Issue issue) {
		super();
		this.issue = issue;
	}

	@Override
	protected Widget onInitialization() {
		TableBuilder tb = ScrumGwt.createFieldTable();

		tb.addFieldRow("Label", issue.getLabelModel());
		tb.addFieldRow("Description", issue.getDescriptionModel());
		tb.addFieldRow("My emoticon", issue.createCurrentUserEmotionEditor());

		return TableBuilder.row(20, tb.createTable(), new CommentsWidget(issue));
	}

}
