package com.example.tiltmidi;
import org.json.JSONObject;
final class Mapping {
 String name="Controller"; int cc=1,channel=1,low=0,high=127,axis=0,manual=64,last=-1; boolean enabled=true,invert=false; double range=64,smooth=.25,filtered=Double.NaN;
 int value(double angle) {
  double raw=axis==2?manual:Math.max(0,Math.min(1,(angle+range)/(2*range)))*(high-low)+low;
  if(invert) raw=low+high-raw;
  filtered=Double.isNaN(filtered)?raw:filtered+smooth*(raw-filtered);
  return (int)Math.max(0,Math.min(127,Math.round(filtered)));
 }
 JSONObject json() throws Exception {JSONObject j=new JSONObject();j.put("name",name);j.put("cc",cc);j.put("channel",channel);j.put("low",low);j.put("high",high);j.put("axis",axis);j.put("manual",manual);j.put("enabled",enabled);j.put("invert",invert);j.put("range",range);j.put("smooth",smooth);return j;}
 static Mapping parse(JSONObject j){Mapping m=new Mapping();m.name=j.optString("name","Controller");m.cc=j.optInt("cc",1);m.channel=j.optInt("channel",1);m.low=j.optInt("low",0);m.high=j.optInt("high",127);m.axis=j.optInt("axis",0);m.manual=j.optInt("manual",64);m.enabled=j.optBoolean("enabled",true);m.invert=j.optBoolean("invert",false);m.range=j.optDouble("range",64);m.smooth=j.optDouble("smooth",.25);return m;}
}
