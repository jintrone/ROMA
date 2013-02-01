package edu.mit.cci.roma.web;

import edu.mit.cci.roma.excel.ExcelSimulation;
import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RooWebScaffold(path = "excelsimulations", formBackingObject = ExcelSimulation.class)
@RequestMapping("/excelsimulations")
@Controller
public class ExcelSimulationController {
}
