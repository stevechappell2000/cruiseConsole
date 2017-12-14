package com.cruise.plugins.cruiseConsole;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.corecruise.cruise.SessionObject;
import com.corecruise.cruise.SessionObjectJSON;
import com.corecruise.cruise.services.interfaces.PluginClientInterface;
import com.corecruise.cruise.services.utils.Services;
import com.corecruise.cruise.testharness.ValidateUser;


public class Runner implements PluginClientInterface{
	ValidateUser vu = null;
	SessionObjectJSON so = null;
    public Runner() {
    	if(null == vu) {
			vu = new ValidateUser();
			vu.initializeValidation();
			so = new SessionObjectJSON();
    	}
    }
    public boolean go(String filename) {
    	boolean ret = false;
    	try {
    		String x = new String(Files.readAllBytes(Paths.get(filename)));
    		//System.out.println(x);
			ret = so.go(this, vu, x,false);
			try {
				System.out.println(so.getResponseJSONPP());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ret;
    }
	public boolean PreProcess(SessionObject sessionObject, Services service) {
		// TODO Auto-generated method stub
		return true;
	}

	public boolean PostProcess(SessionObject sessionObject, Services service) {
		// TODO Auto-generated method stub
		return true;
	}

	public void ProcessingError(SessionObject sessionObject) {
		// TODO Auto-generated method stub
		
	}

}
