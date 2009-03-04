package scrum.client.project;

import ilarkesto.gwt.client.AWidget;
import ilarkesto.gwt.client.ToolbarWidget;
import scrum.client.ScrumGwtApplication;
import scrum.client.common.BlockListWidget;
import scrum.client.common.GroupWidget;
import scrum.client.workspace.WorkareaWidget;

import com.google.gwt.user.client.ui.ClickListener;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Widget;

public class ProductBacklogWidget extends AWidget {

	public BlockListWidget<RequirementWidget> list;

	@Override
	protected Widget onInitialization() {
		list = new BlockListWidget<RequirementWidget>();
		ToolbarWidget toolbar = new ToolbarWidget(true);
		toolbar.addButton("Create new Requirement").addClickListener(new CreateClickListener());

		FlowPanel panel = new FlowPanel();
		panel.add(toolbar);
		panel.add(new HTML("<br>"));
		panel.add(list);

		return new GroupWidget("Product Backlog", panel);
	}

	@Override
	protected void onUpdate() {
		list.update();
		list.clear();
		for (Requirement item : ScrumGwtApplication.get().getProject().getRequirements()) {
			list.addBlock(new RequirementWidget(item));
		}
	}

	class CreateClickListener implements ClickListener {

		public void onClick(Widget sender) {
			Requirement requirement = ScrumGwtApplication.get().getProject().createNewRequirement();
			RequirementWidget block = new RequirementWidget(requirement);
			list.addBlock(block);
			list.selectBlock(block);
		}
	}

	public static ProductBacklogWidget get() {
		return WorkareaWidget.get().getProductBacklog();
	}
}
