package org.one2team.highcharts.shared.dynamic;

import org.one2team.gwt.shared.Array;
import org.one2team.highcharts.shared.ChartOptions;

public interface Chart {
  
  void _destroy ();
  
  ChartOptions getOptions ();
  
  Array<Series> getSeries ();

}
