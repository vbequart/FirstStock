package view;

import IA.myIA;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import plugginLoad.CashPlugin;
import java.awt.BorderLayout;


public class CashMenu extends PluginStyle {

    private CashMenu cash = this;
    private JPanel pane = null;

    public CashMenu(String name, WorkSpace workSpace, Window window) {
        super(name, workSpace, window);
        this.init();
    }

    public void init() {
        button.addActionListener(new CashMenu.EventAccess());
        myIA IA = new myIA();
        this.setLayout(new BorderLayout(0,0));
        pane = IA.makePredictionTresorerie();
        this.add(pane, BorderLayout.CENTER);

    }

    public class EventAccess implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent clic) {
            cash.loadMenu();
        }
    }

    public void loadMenu() {
        plugin.getWorkSpace().getContentPane().removeAll();
        plugin.add(pane, BorderLayout.CENTER);
        plugin.getWorkSpace().setContentPane(plugin);
        plugin.getWorkSpace().getContentPane().validate();
        plugin.getWorkSpace().setTitle(plugin.name);
        plugin.setVisible(true);
        plugin.getToolsBox().pane.removeAll();
        
        System.out.println("view.Window.load : " + name);
        if (this.window.files.size() > 0) {
            this.window.pluginsLoader.setFiles(this.window.convertArrayListToArrayString(this.window.files));
            try {
                this.loadPlugins(this.window.pluginsLoader.loadAllCashPlugins());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        plugin.getToolsBox().pane.validate();

    }

    public void loadPlugins(CashPlugin[] cashplugins) {
        for (int index = 0; index < cashplugins.length; index++) {
            this.window.cashPlugins.add(cashplugins[index]);
            PluginStyle c = new PluginStyle(cashplugins[index].getLibelle(), workSpace, window);
        }
    }

    @Override
    public void addToTools() {
        this.getWindow().addJMenu(button);
    }
}
