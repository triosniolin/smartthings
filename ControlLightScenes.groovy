/**
 *  Switches Control Light Scenes
 *
 *  Copyright 2017 Will Cole
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
    name: "Control Light Scenes",
    namespace: "triosniolin",
    author: "Will Cole",
    description: "Using switches, control scenes for light(s).",
    category: "Convenience",
    iconUrl: "https://s3.amazonaws.com/smartapp-icons/Convenience/Cat-Convenience.png",
    iconX2Url: "https://s3.amazonaws.com/smartapp-icons/Convenience/Cat-Convenience@2x.png",
    iconX3Url: "https://s3.amazonaws.com/smartapp-icons/Convenience/Cat-Convenience@2x.png")


preferences {
    page(name: "page1")
	page(name: "page2")
	page(name: "page3")
	page(name: "page4")
    page(name: "page5")
    page(name: "page6")
}
def page1() {
	dynamicPage(name: "page1", title: "Select devices:", nextPage: "page2", uninstall:true) {
        section("Number of Scenes (such as on, off, movie, party)") {
            input "scenes", "number", 
                title: "Number of Scenes (1-5)", 
                range: "1..5",
                defaultValue: "3",
                required: true,
                submitOnChange: true
        }
        section("Device to control") {
                input "slaves", "capability.colorTemperature", 
                    multiple: true, 
                    title: "Slave Color Temp bulb(s)...", 
                    required: true
        }

    }
}

def page2() {
    def i = 1
	if (scenes > i) {
	dynamicPage(name: "page2", title: "Select Scene $i", nextPage: "page3") {
            section("Switch $i") {
                input "switch$i", "capability.switch", 
                    multiple: false, 
                    title: "Switch To Enable Scene $i", 
                    required: true
            }
            section("Switch $i Color Temp") {
                input "Temp$i", "number", 
                    title: "Switch $i Color Temp (Kelvin)", 
                    range: "2700..6500",
                    defaultValue: "6000",
                    required: true
            }
            section("Switch $i Dim Level") {
                input "Dim$i", "number", 
                    title: "Switch $i Dim Level", 
                    range: "0..100",
                    defaultValue: "25",
                    required: true
            }
        }
   } else {
    dynamicPage(name: "page2", title: "Select Scene $i", install:true) {
            section("Switch $i") {
                input "switch$i", "capability.switch", 
                    multiple: false, 
                    title: "Switch To Enable Scene $i", 
                    required: true
            }
            section("Switch $i Color Temp") {
                input "Temp$i", "number", 
                    title: "Switch $i Color Temp (Kelvin)", 
                    range: "2700..6500",
                    defaultValue: "6000",
                    required: true
            }
            section("Switch $i Dim Level") {
                input "Dim$i", "number", 
                    title: "Switch $i Dim Level", 
                    range: "0..100",
                    defaultValue: "25",
                    required: true
            }
        }
    }
}
def page3() {
	def i = 2
if (scenes > i) {
	dynamicPage(name: "page3", title: "Select Scene $i", nextPage: "page4") {
            section("Switch $i") {
                input "switch$i", "capability.switch", 
                    multiple: false, 
                    title: "Switch To Enable Scene $i", 
                    required: true
            }
            section("Switch $i Color Temp") {
                input "Temp$i", "number", 
                    title: "Switch $i Color Temp (Kelvin)", 
                    range: "2700..6500",
                    defaultValue: "6000",
                    required: true
            }
            section("Switch $i Dim Level") {
                input "Dim$i", "number", 
                    title: "Switch $i Dim Level", 
                    range: "0..100",
                    defaultValue: "25",
                    required: true
            }
        }
   } else {
    dynamicPage(name: "page3", title: "Select Scene $i", install:true) {
            section("Switch $i") {
                input "switch$i", "capability.switch", 
                    multiple: false, 
                    title: "Switch To Enable Scene $i", 
                    required: true
            }
            section("Switch $i Color Temp") {
                input "Temp$i", "number", 
                    title: "Switch $i Color Temp (Kelvin)", 
                    range: "2700..6500",
                    defaultValue: "6000",
                    required: true
            }
            section("Switch $i Dim Level") {
                input "Dim$i", "number", 
                    title: "Switch $i Dim Level", 
                    range: "0..100",
                    defaultValue: "25",
                    required: true
            }
        }
    }
}
def page4() {
	def i = 3
if (scenes > i) {
	dynamicPage(name: "page4", title: "Select Scene $i", nextPage: "page5") {
            section("Switch $i") {
                input "switch$i", "capability.switch", 
                    multiple: false, 
                    title: "Switch To Enable Scene $i", 
                    required: true
            }
            section("Switch $i Color Temp") {
                input "Temp$i", "number", 
                    title: "Switch $i Color Temp (Kelvin)", 
                    range: "2700..6500",
                    defaultValue: "6000",
                    required: true
            }
            section("Switch $i Dim Level") {
                input "Dim$i", "number", 
                    title: "Switch $i Dim Level", 
                    range: "0..100",
                    defaultValue: "25",
                    required: true
            }
        }
   } else {
        dynamicPage(name: "page4", title: "Select Scene $i", install:true) {
            section("Switch $i") {
                input "switch$i", "capability.switch", 
                    multiple: false, 
                    title: "Switch To Enable Scene $i", 
                    required: true
            }
            section("Switch $i Color Temp") {
                input "Temp$i", "number", 
                    title: "Switch $i Color Temp (Kelvin)", 
                    range: "2700..6500",
                    defaultValue: "6000",
                    required: true
            }
            section("Switch $i Dim Level") {
                input "Dim$i", "number", 
                    title: "Switch $i Dim Level", 
                    range: "0..100",
                    defaultValue: "25",
                    required: true
            }
        }
    }
}
def page5() {
	def i = 4
	if (scenes > i) {
        dynamicPage(name: "page5", title: "Select Scene $i", nextPage: "page6") {
            section("Switch $i") {
                input "switch$i", "capability.switch", 
                    multiple: false, 
                    title: "Switch To Enable Scene $i", 
                    required: true
            }
            section("Switch $i Color Temp") {
                input "Temp$i", "number", 
                    title: "Switch $i Color Temp (Kelvin)", 
                    range: "2700..6500",
                    defaultValue: "6000",
                    required: true
            }
            section("Switch $i Dim Level") {
                input "Dim$i", "number", 
                    title: "Switch $i Dim Level", 
                    range: "0..100",
                    defaultValue: "25",
                    required: true
            }
        }
       } else {
        dynamicPage(name: "page5", title: "Select Scene $i", install:true) {
                section("Switch $i") {
                    input "switch$i", "capability.switch", 
                        multiple: false, 
                        title: "Switch To Enable Scene $i", 
                        required: true
                }
                section("Switch $i Color Temp") {
                    input "Temp$i", "number", 
                        title: "Switch $i Color Temp (Kelvin)", 
                        range: "2700..6500",
                        defaultValue: "6000",
                        required: true
                }
                section("Switch $i Dim Level") {
                    input "Dim$i", "number", 
                        title: "Switch $i Dim Level", 
                        range: "0..100",
                        defaultValue: "25",
                        required: true
                }
            }
    }
}
def page6() {
	def i = 5
        dynamicPage(name: "page6", title: "Select Scene $i", install:true) {
            section("Switch $i") {
                input "switch$i", "capability.switch", 
                    multiple: false, 
                    title: "Switch To Enable Scene $i", 
                    required: true
            }
            section("Switch $i Color Temp") {
                input "Temp$i", "number", 
                    title: "Switch $i Color Temp (Kelvin)", 
                    range: "2700..6500",
                    defaultValue: "6000",
                    required: true
            }
            section("Switch $i Dim Level") {
                input "Dim$i", "number", 
                    title: "Switch $i Dim Level", 
                    range: "0..100",
                    defaultValue: "25",
                    required: true
            }
        
    }
}
def installed()
{
if (switch1) {
subscribe (switch1, "switch.on", switch1Handler)
}
if (switch2) {
subscribe (switch2, "switch.on", switch2Handler)
}
if (switch3) {
subscribe (switch3, "switch.on", switch3Handler)
}
if (switch4) {
subscribe (switch4, "switch.on", switch4Handler)
}
if (switch5) {
subscribe (switch5, "switch.on", switch5Handler)
}
}

def updated()
{
	unsubscribe()
if (switch1) {
subscribe (switch1, "switch.on", switch1Handler)
}
if (switch2) {
subscribe (switch2, "switch.on", switch2Handler)
}
if (switch3) {
subscribe (switch3, "switch.on", switch3Handler)
}
if (switch4) {
subscribe (switch4, "switch.on", switch4Handler)
}
if (switch5) {
subscribe (switch5, "switch.on", switch5Handler)
}
	log.info "subscribed to all of switches events"
}



def switch1Handler(evt){	
    def Level1 = Dim1.toInteger()
    def Color1 = Temp1.toInteger()
	log.info "switch1Handler Event: ${evt.value}"
	slaves?.setColorTemperature(Color1)
    slaves?.setLevel(Level1)
}
def switch2Handler(evt){	
    def Level2 = Dim2.toInteger()
    def Color2 = Temp2.toInteger()
	log.info "switch2Handler Event: ${evt.value}"
	slaves?.setColorTemperature(Color2)
    slaves?.setLevel(Level2)
}
def switch3Handler(evt){	
    def Level3 = Dim3.toInteger()
    def Color3 = Temp3.toInteger()
	log.info "switch3Handler Event: ${evt.value}"
	slaves?.setColorTemperature(Color3)
    slaves?.setLevel(Level3)
}
def switch4Handler(evt){	
    def Level4 = Dim4.toInteger()
    def Color4 = Temp4.toInteger()
	log.info "switch4Handler Event: ${evt.value}"
	slaves?.setColorTemperature(Color4)
    slaves?.setLevel(Level4)
}
def switch5Handler(evt){	
    def Level5 = Dim5.toInteger()
    def Color5 = Temp5.toInteger()
	log.info "switch5Handler Event: ${evt.value}"
	slaves?.setColorTemperature(Color5)
    slaves?.setLevel(Level5)
}
