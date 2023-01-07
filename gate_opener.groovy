/**
 *  Gate Opener SmartApp for eWeLink Gate Opener
 *
 *  Copyright 2023 Will Cole
 *
 *  Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 *  in compliance with the License. You may obtain a copy of the License at:
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software distributed under the License is distributed
 *  on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License
 *  for the specific language governing permissions and limitations under the License.
 *
 */
definition(
    name: "Gate Opener Control",
    namespace: "triosniolin",
    author: "Will Cole",
    description: "Control eWeLink Gate Opener",
    category: "Convenience",
    iconUrl: "https://s3.amazonaws.com/smartapp-icons/Convenience/Cat-Convenience.png",
    iconX2Url: "https://s3.amazonaws.com/smartapp-icons/Convenience/Cat-Convenience@2x.png",
    iconX3Url: "https://s3.amazonaws.com/smartapp-icons/Convenience/Cat-Convenience@2x.png")


preferences {
	page(name: "page1")
	page(name: "page2")
	page(name: "page3")
	page(name: "lastpage")
}
def page1() {
	dynamicPage(name: "page1", title: "Select virtual switch:", nextPage: "page2", uninstall:true) {
        section("Switch to act as input to gate opener logic") {
		input "switch1", "capability.switch", 
                    multiple: false, 
                    title: "Virtual switch",
		    		required: true,
        }

    }
}

def page2() {
	dynamicPage(name: "page2", title: "Select eWeLink Opener Output:", nextPage: "page2", uninstall:true) {
        section("eWeLink switch (or other relay output)") {
		input "switch2", "capability.switch", 
                    multiple: false, 
                    title: "Output switch",
		    		required: true,
        }

    }
}

def page3() {
  dynamicPage(name: "page2", title: "Select eWeLink Opener Output:", nextPage: "page2", uninstall:true) {
	        section("Seconds to hold switch output on") {
            input "seconds", "number", 
                title: "Seconds to hold output on (1-15)", 
                range: "1..15",
                defaultValue: "3",
                required: true,
                submitOnChange: true
        }
  }
}

def lastpage() {
	dynamicPage(name: "lastpage", title: "Name app and configure modes", install: true, uninstall: true) {
        section([mobileOnly:true]) {
            label title: "Assign a name", required: false
            mode title: "Set for specific mode(s)", required: false
        }
	}
}

def installed(){
  if (switch1) {
  subscribe (switch1, "switch.on", switch1Handler)
  }
  log.info "subscribed to all of switches events"
}

def updated()
{
	unsubscribe()
  if (switch1) {
  subscribe (switch1, "switch.on", switch1Handler)
  }
	log.info "subscribed to all of switches events"
}



def switch1Handler(evt){	
	log.info "switch1Handler Event: ${evt.value}"
	switch2.on()
  pause(seconds * 1000)
  switch1.off()
  switch2.off()
}
