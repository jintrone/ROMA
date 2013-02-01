package edu.mit.cci.roma.web;

import edu.mit.cci.roma.excel.ExcelVariable;
import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RooWebScaffold(path = "excelvariables", formBackingObject = ExcelVariable.class)
@RequestMapping("/excelvariables")
@Controller
public class ExcelVariableController {
}
