package com.EmotivServiceNow;

import com.sun.jna.Pointer; // Emotiv JAR
import com.sun.jna.ptr.*; // Emotiv JAR

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import org.apache.http.HttpException;
import org.apache.http.client.ClientProtocolException;

/** Simple example of JNA interface mapping and usage. */

public class EmoTitan_ServiceNow_App {
	
	static Timer timer = new Timer();
	static boolean timeout = false;


	public static void main(String[] args) throws HttpException, ClientProtocolException, IOException {
		Pointer eEvent = Edk.INSTANCE.IEE_EmoEngineEventCreate();
		Pointer eState = Edk.INSTANCE.IEE_EmoStateCreate();
		IntByReference userID = null;
		short composerPort = 1726; //Port for Emotiv Composer application
		short enginePort = 3008; //Port for Emotiv EEG Headset application
		int option = 1; //options: (1)Emotiv EEG Headset application (EmoEngine) or (2)Emotiv Composer application (EmoComposer)
		int state = 0;
		
		userID = new IntByReference(0);

		switch (option) {
		case 1: {
			// Connect to EmoEngine
			if (Edk.INSTANCE.IEE_EngineRemoteConnect("127.0.0.1", enginePort, "Emotiv Systems-5") != EdkErrorCode.EDK_OK
					.ToInt()) {
				System.out.println("Emotiv Engine start up failed.");
				return;
			}
			System.out.println("Connected to EmoEngine on [127.0.0.1]");
			break;
		}
		case 2: {
			// Connect to EmoComposer
			System.out.println("Target IP of EmoComposer: [127.0.0.1] ");

			if (Edk.INSTANCE.IEE_EngineRemoteConnect("127.0.0.1", composerPort,
					"Emotiv Systems-5") != EdkErrorCode.EDK_OK.ToInt()) {
				System.out.println("Cannot connect to EmoComposer on [127.0.0.1]");
				return;
			}
			System.out.println("Connected to EmoComposer on [127.0.0.1]");
			break;
		}
		default:
			System.out.println("Invalid option...");
			return;
		}

		while (true) {
			state = Edk.INSTANCE.IEE_EngineGetNextEvent(eEvent);

			// New event needs to be handled
			if (state == EdkErrorCode.EDK_OK.ToInt()) {

				int eventType = Edk.INSTANCE.IEE_EmoEngineEventGetType(eEvent);
				Edk.INSTANCE.IEE_EmoEngineEventGetUserId(eEvent, userID);

				// Log the EmoState if it has been updated
				if (eventType == Edk.IEE_Event_t.IEE_EmoStateUpdated.ToInt()) {

					Edk.INSTANCE.IEE_EmoEngineEventGetEmoState(eEvent, eState);
					float timestamp = EmoState.INSTANCE.IS_GetTimeFromStart(eState);
					System.out.println(timestamp + " : New EmoState from user " + userID.getValue());

					System.out.print("WirelessSignalStatus: ");
					System.out.println(EmoState.INSTANCE.IS_GetWirelessSignalStatus(eState));

					// Logging Cognitive Actions
					System.out.print("CognitivGetCurrentAction: ");
					System.out.println(EmoState.INSTANCE.IS_MentalCommandGetCurrentAction(eState));
					System.out.print("CurrentActionPower: ");
					System.out.println(EmoState.INSTANCE.IS_MentalCommandGetCurrentActionPower(eState));

					// Check for pushing action at a power over 0.61 and timeout
					// false
					if ((EmoState.INSTANCE.IS_MentalCommandGetCurrentAction(eState) == 2) 
							&& (EmoState.INSTANCE.IS_MentalCommandGetCurrentActionPower(eState) > 0.61)
							&& (timeout == false)) {
						System.out.println("CurrentActionPower level achieved go to POST  ");
						POST.restPost();
						timerStart(true);
					}
					// Check for Pulling action at a power over 0.61 and timeout
					// false
					if ((EmoState.INSTANCE.IS_MentalCommandGetCurrentAction(eState) == 4)
							&& (EmoState.INSTANCE.IS_MentalCommandGetCurrentActionPower(eState) > 0.61)
							&& (timeout == false)) {
						System.out.println("CurrentActionPower level achieved go to POST");
						POST.restPost1();
						timerStart(true);
					}
					// Check for Left action at a power over 0.61 and timeout
					// false
					if ((EmoState.INSTANCE.IS_MentalCommandGetCurrentAction(eState) == 32)
							&& (EmoState.INSTANCE.IS_MentalCommandGetCurrentActionPower(eState) > 0.41)
							&& (timeout == false)) {
						System.out.println(EmoState.INSTANCE.IS_MentalCommandGetCurrentAction(eState));
						System.out.println("CurrentActionPower level achieved go to POST");
						POST.restPost2();
						timerStart(true);
					}
					// Check for Right action at a power over 0.61 and timeout
					// false
					if ((EmoState.INSTANCE.IS_MentalCommandGetCurrentAction(eState) == 64)
							&& (EmoState.INSTANCE.IS_MentalCommandGetCurrentActionPower(eState) > 0.61)
							&& (timeout == false)) {
						System.out.println(EmoState.INSTANCE.IS_MentalCommandGetCurrentAction(eState));
						System.out.println("CurrentActionPower level achieved go to POST");
						POST.restPost3();
						timerStart(true);
					}					
				}

			} else if (state != EdkErrorCode.EDK_NO_EVENT.ToInt()) {
				System.out.println("Internal error in Emotiv Engine!");
				break;
			}
		}

		Edk.INSTANCE.IEE_EngineDisconnect();
		System.out.println("Disconnected!");
	}
	public static void timerStart(boolean startValue) {
		if (startValue == true) {
			timeout = true;
			// Wait 10 seconds for head set
			timer.schedule(new TimerTask() {
				public void run() {
					timeout = false;
					System.out.println("Timout");
				}
			}, 10000);
		}
	}
}
