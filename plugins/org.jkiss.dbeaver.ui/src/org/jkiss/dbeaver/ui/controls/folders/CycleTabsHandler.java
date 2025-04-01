package org.jkiss.dbeaver.ui.controls.folders;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import javax.swing.JOptionPane;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Control;
public class CycleTabsHandler extends AbstractHandler {

    @Override
    public Object execute(ExecutionEvent event) throws ExecutionException {

        Control control = Display.getCurrent().getFocusControl();
        TabbedFolderComposite folderComposite = findTabbedFolderComposite(control);

        if (folderComposite != null) {
            folderComposite.cycleTabs();
        }
        return null;
    }

    private TabbedFolderComposite findTabbedFolderComposite(Control control) {
        while (control != null) {
            if (control instanceof TabbedFolderComposite) {
                return (TabbedFolderComposite) control;
            }
            control = control.getParent();
        }
        return null;
    }
}
