package web;

import agent.Agent;
import agent.AgentManager;
import agent.Block;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

// Main controller class for all agent methods
@RestController
@RequestMapping(path="/agent")
public class AgentController {

    private static final AgentManager agentManager = new AgentManager();

    @RequestMapping(method=GET)
    public Agent getAgent(@RequestParam("name") String name) {
        return agentManager.getAgent(name);
    }

    @RequestMapping(method=DELETE)
    public void removeAgent(@RequestParam("name") String name) {
        agentManager.removeAgent(name);
    }

    @RequestMapping(method=POST, params = {"name", "port"})
    public Agent addAgent(@RequestParam("name") String name, @RequestParam("port") int port) {
        return agentManager.addAgent(name, port);
    }

    @RequestMapping(path="all", method=GET)
    public List<Agent> getAllAgents() {
        return agentManager.getAllAgents();
    }

    @RequestMapping(path="all", method=DELETE)
    public void removeAllAgents() {
        agentManager.removeAllAgents();
    }

    @RequestMapping(method=POST, path="mine")
    public Block createBlock(@RequestParam(value="agent") final String name) {
        return agentManager.createBlock(name);
    }

}