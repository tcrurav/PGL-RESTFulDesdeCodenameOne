/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp;

import com.codename1.components.InfiniteProgress;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Component;
import com.codename1.ui.Dialog;
import com.codename1.ui.Label;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Hashtable;

/**
 * GUI builder created Form
 *
 * @author Tiburcio
 */
public class FormCoches extends com.codename1.ui.Form {

    public FormCoches() {
        this(com.codename1.ui.util.Resources.getGlobalResources());
    }
    
    public FormCoches(com.codename1.ui.util.Resources resourceObjectInstance) {
        initGuiBuilderComponents(resourceObjectInstance);
    }

//-- DON'T EDIT BELOW THIS LINE!!!
    private com.codename1.ui.Button gui_Button = new com.codename1.ui.Button();


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void guiBuilderBindComponentListeners() {
        EventCallbackClass callback = new EventCallbackClass();
        gui_Button.addActionListener(callback);
    }

    class EventCallbackClass implements com.codename1.ui.events.ActionListener, com.codename1.ui.events.DataChangedListener {
        private com.codename1.ui.Component cmp;
        public EventCallbackClass(com.codename1.ui.Component cmp) {
            this.cmp = cmp;
        }

        public EventCallbackClass() {
        }

        public void actionPerformed(com.codename1.ui.events.ActionEvent ev) {
            com.codename1.ui.Component sourceComponent = ev.getComponent();

            if(sourceComponent.getParent().getLeadParent() != null && (sourceComponent.getParent().getLeadParent() instanceof com.codename1.components.MultiButton || sourceComponent.getParent().getLeadParent() instanceof com.codename1.components.SpanButton)) {
                sourceComponent = sourceComponent.getParent().getLeadParent();
            }

            if(sourceComponent == gui_Button) {
                onButtonActionEvent(ev);
            }
        }

        public void dataChanged(int type, int index) {
        }
    }
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        guiBuilderBindComponentListeners();
        setLayout(new com.codename1.ui.layouts.LayeredLayout());
        setInlineStylesTheme(resourceObjectInstance);
                setInlineStylesTheme(resourceObjectInstance);
        setTitle("FormCoches");
        setName("FormCoches");
        addComponent(gui_Button);
        gui_Button.setText("Descargar datos");
                gui_Button.setInlineStylesTheme(resourceObjectInstance);
        gui_Button.setName("Button");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Button.getParent().getLayout()).setInsets(gui_Button, "16.693163% auto auto 17.647058%").setReferenceComponents(gui_Button, "-1 -1 -1 -1").setReferencePositions(gui_Button, "0.0 0.0 0.0 0.0");
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!
    public void onButtonActionEvent(com.codename1.ui.events.ActionEvent ev) {
    mostrarDatos(ev.getComponent());
    }

    private void mostrarDatos(Component c){
        ConnectionRequest r = new ConnectionRequest(){
            Hashtable h;
            @Override
            protected void postResponse() {
//                super.postResponse(); //To change body of generated methods, choose Tools | Templates.
                c.getComponentForm().addComponent(new Label("marca: " + h.get("marca") + ", modelo: " + h.get("modelo")));
                c.getComponentForm().revalidate();
            }

            @Override
            protected void readResponse(InputStream input) throws IOException {
//                super.readResponse(input); //To change body of generated methods, choose Tools | Templates.
                JSONParser p = new JSONParser();
                h = p.parse(new InputStreamReader(input));
                System.out.println("" + h);
            }
            
        };
        r.setUrl("http://192.168.1.178:8080/Coches/webresources/coches");
        r.setPost(false);
        r.addArgument("q", "@codename-one");
        InfiniteProgress prog = new InfiniteProgress();
        Dialog diag = prog.showInifiniteBlocking();
        r.setDisposeOnCompletion(diag);
        NetworkManager.getInstance().addToQueue(r);
    }

}
