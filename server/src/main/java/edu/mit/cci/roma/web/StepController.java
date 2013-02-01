package edu.mit.cci.roma.web;

import edu.mit.cci.roma.server.Step;
import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RooWebScaffold(path = "steps", formBackingObject = Step.class)
@RequestMapping("/steps")
@Controller
public class StepController {
}
