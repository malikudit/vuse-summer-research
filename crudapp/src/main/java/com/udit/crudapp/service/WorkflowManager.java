package com.udit.crudapp.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WorkflowManager {
    public static void main(String[] args) throws Exception {
        ProcessBuilder processBuilder = new ProcessBuilder();
        processBuilder.command("bash", "-c", "argo submit -n argo https://raw.githubusercontent.com/argoproj/argo-workflows/master/examples/hello-world.yaml");
        try {
            Process process = processBuilder.start();
            StringBuilder output = new StringBuilder();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
    
            String line;
            while ((line = reader.readLine()) != null) {
                output.append(line + "\n");
            }
    
            int exitVal = process.waitFor();
            if (exitVal == 0) {
                System.out.println("Success!");
                System.out.println(output);
                System.exit(0);
            } 
            else {
                System.out.println("Error! The required task could not be completed.");
            }
    
        } 
        catch (IOException e) {
            e.printStackTrace();

        } 
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String workflowSubmit() {
        return "argo submit -n argo" + " ";
    }

    public String workflowList() {
        return "argo list -n argo";
    }

    public String workflowTerminate() {
        return "argo terminate -n argo" + "";
    }

    public String workflowSuspend() {
        return "argo suspend -n argo" + "";
    }


}