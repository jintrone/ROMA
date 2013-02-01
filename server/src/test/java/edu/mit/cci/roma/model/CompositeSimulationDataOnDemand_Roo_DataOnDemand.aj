// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package edu.mit.cci.roma.model;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;

privileged aspect CompositeSimulationDataOnDemand_Roo_DataOnDemand {
    
    declare @type: CompositeSimulationDataOnDemand: @Component;
    
    private Random CompositeSimulationDataOnDemand.rnd = new java.security.SecureRandom();
    
    private List<CompositeServerSimulation> CompositeSimulationDataOnDemand.data;
    
    public CompositeServerSimulation CompositeSimulationDataOnDemand.getNewTransientCompositeSimulation(int index) {
        CompositeServerSimulation obj = new CompositeServerSimulation();
        obj.setInputs(null);
        obj.setOutputs(null);
        obj.setRunStrategy(null);
        obj.setCreated(new java.util.GregorianCalendar(java.util.Calendar.getInstance().get(java.util.Calendar.YEAR), java.util.Calendar.getInstance().get(java.util.Calendar.MONTH), java.util.Calendar.getInstance().get(java.util.Calendar.DAY_OF_MONTH), java.util.Calendar.getInstance().get(java.util.Calendar.HOUR_OF_DAY), java.util.Calendar.getInstance().get(java.util.Calendar.MINUTE), java.util.Calendar.getInstance().get(java.util.Calendar.SECOND) + new Double(Math.random() * 1000).intValue()).getTime());
        obj.setSimulationVersion(new Integer(index).longValue());
        obj.setDescription(null);
        obj.setName(null);
        obj.setUrl(null);
        obj.setInputs(null);
        obj.setOutputs(null);
        return obj;
    }
    
    public CompositeServerSimulation CompositeSimulationDataOnDemand.getSpecificCompositeSimulation(int index) {
        init();
        if (index < 0) index = 0;
        if (index > (data.size() - 1)) index = data.size() - 1;
        CompositeServerSimulation obj = data.get(index);
        return CompositeServerSimulation.findCompositeSimulation(obj.getId());
    }
    
    public CompositeServerSimulation CompositeSimulationDataOnDemand.getRandomCompositeSimulation() {
        init();
        CompositeServerSimulation obj = data.get(rnd.nextInt(data.size()));
        return CompositeServerSimulation.findCompositeSimulation(obj.getId());
    }
    
    public boolean CompositeSimulationDataOnDemand.modifyCompositeSimulation(CompositeServerSimulation obj) {
        return false;
    }
    
    public void CompositeSimulationDataOnDemand.init() {
        data = CompositeServerSimulation.findCompositeSimulationEntries(0, 10);
        if (data == null) throw new IllegalStateException("Find entries implementation for 'CompositeSimulation' illegally returned null");
        if (!data.isEmpty()) {
            return;
        }
        
        data = new java.util.ArrayList<CompositeServerSimulation>();
        for (int i = 0; i < 10; i++) {
            CompositeServerSimulation obj = getNewTransientCompositeSimulation(i);
            obj.persist();
            obj.flush();
            data.add(obj);
        }
    }
    
}