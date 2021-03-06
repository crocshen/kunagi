package scrum.client.sprint;

import ilarkesto.core.scope.Scope;
import ilarkesto.gwt.client.Gwt;
import scrum.client.common.TooltipBuilder;
import scrum.client.project.Requirement;
import scrum.client.workspace.ProjectWorkspaceWidgets;
import scrum.client.workspace.Ui;

public class SwitchToNextSprintAction extends GSwitchToNextSprintAction {

	@Override
	public String getLabel() {
		return "Switch to next Sprint";
	}

	@Override
	public String getTooltip() {
		TooltipBuilder tb = new TooltipBuilder("Finish the current Sprint and replace it by the next one.");
		if (!getCurrentProject().isProductOwner(getCurrentUser())) tb.addRemark(TooltipBuilder.NOT_PRODUCT_OWNER);
		return tb.getTooltip();
	}

	@Override
	public boolean isExecutable() {
		return true;
	}

	@Override
	public boolean isPermitted() {
		if (!getCurrentProject().isProductOwner(getCurrentUser())) return false;
		return true;
	}

	@Override
	protected void onExecute() {
		if (!Gwt.confirm("Switch to next Sprint?")) return;
		Scope.get().getComponent(Ui.class).lock("Switching to next Sprint");
		new SwitchToNextSprintServiceCall().execute(new Runnable() {

			public void run() {
				Scope.get().getComponent(ProjectWorkspaceWidgets.class).showSprintBacklog((Requirement) null);
				Scope.get().getComponent(Ui.class).unlock();
			}
		});
	}
}
