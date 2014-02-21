/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servis.manager.akcije;

import com.dobrivoje.utilities.warnings.Display;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionRegistration;
import org.openide.filesystems.FileChooserBuilder;
import org.openide.filesystems.FileObject;
import org.openide.filesystems.FileUtil;
import org.openide.util.NbBundle.Messages;

@ActionID(
        category = "File",
        id = "servis.manager.akcije.OpenFile"
)
@ActionRegistration(
        displayName = "#CTL_OpenFile"
)
@ActionReference(path = "Menu/File", position = 100)
@Messages("CTL_OpenFile=Otvaranje Fajla")
public final class ManagementOpenFileAction implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        File file = new FileChooserBuilder("user-dir")
                .setTitle("Otvori Excel")
                .setApproveText("Open")
                .showOpenDialog();

        FileObject fo;

        if (file != null) {
            fo = FileUtil.toFileObject(file);
            Display.obavestenje("path: " + fo.getPath());
        }
    }
}
