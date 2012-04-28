/*
   Copyright 2012 Patrick Ahlbrecht

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
*/

package de.onyxbits.sensorreadout;

import android.widget.*;
import android.view.*;
import android.content.*;
import android.hardware.*;
import java.util.*;

/**
 * <code>Adapter</code> for plugging a <code>Sensor</code> into a <code>ListView</code>
 */
class SensorAdapter extends ArrayAdapter<Sensor> {

  public SensorAdapter(Context context, int textViewResourceId, List<Sensor> sensors) {
    super(context, textViewResourceId, sensors);
  }
  
  @Override
  public View getView(int position, View convertView, ViewGroup parent) {
    View ret;
    
    Sensor sensor = getItem(position);
    LayoutInflater inflater = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    ret = inflater.inflate(R.layout.identifierplate,null);
    
    ((TextView)ret.findViewById(R.id.sensor_name)).setText(sensor.getName());
    ((TextView)ret.findViewById(R.id.sensor_vendor)).setText(sensor.getVendor());
    ((TextView)ret.findViewById(R.id.sensor_power)).setText(sensor.getPower()+" mA");
            
    return ret;
  }
}