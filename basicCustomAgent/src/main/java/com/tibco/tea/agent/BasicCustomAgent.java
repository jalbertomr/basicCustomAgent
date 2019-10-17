package com.tibco.tea.agent;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;

import com.tibco.tea.agent.annotations.TeaOperation;
import com.tibco.tea.agent.annotations.TeaParam;
import com.tibco.tea.agent.api.BaseTeaObject;
import com.tibco.tea.agent.api.TopLevelTeaObject;
import com.tibco.tea.agent.server.TeaAgentServer;
     

public class BasicCustomAgent implements TopLevelTeaObject{
    private static final String NAME = "basicOperation";
    private static final String DESC = "Basic Custom Agent";
    
    public String getDescription() {
        return DESC;
    }
    
    public String getName() {
        return NAME;
    }
    
    public Collection<BaseTeaObject> getMembers() {
        return Collections.emptyList();
    }
    
    public String getTypeDescription() {
        return "Top level type for Basic Custom Agent";
    }
    
    public String getTypeName() {
        return "BasicCustomldTopLevelType";
    }

    @TeaOperation(name = NAME, description = "Mostrar un texto")
    public String operacionMostrarTexto(
            @TeaParam(name = "mensajedeltexto", description = "Parametro, mensaje del texto") final String mensajeTexto) throws IOException {
        return "Se Muestra el Texto: " + mensajeTexto;
    }
    
    public static void main(final String[] args) throws Exception {
        TeaAgentServer server = new TeaAgentServer("BasicCustomAgent", "1.0", "Basci Custom World Agent", 1234, "/basiccustomagent", true);
        server.registerInstance(new BasicCustomAgent());
        server.start();
    }
}
