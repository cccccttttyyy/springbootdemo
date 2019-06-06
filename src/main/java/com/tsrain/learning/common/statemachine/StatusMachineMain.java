package com.tsrain.learning.common.statemachine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.state.State;

public class StatusMachineMain implements CommandLineRunner {

    @Autowired
    private StateMachine<RegStatusEnum, RegEventEnum> stateMachine;

    public static void main(String[] args) {
        SpringApplication.run(StatusMachineMain.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        stateMachine.start();
        stateMachine.sendEvent(RegEventEnum.CONNECT);
        stateMachine.sendEvent(RegEventEnum.REGISTER);
        stateMachine.sendEvent(RegEventEnum.REGISTER_SUCCESS);
        stateMachine.sendEvent(RegEventEnum.UN_REGISTER);
        stateMachine.sendEvent(RegEventEnum.CONNECT);
        State<RegStatusEnum, RegEventEnum> state = stateMachine.getState();
        System.out.println(state.getId());
    }
}