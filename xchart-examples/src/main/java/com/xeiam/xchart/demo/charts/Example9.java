/**
 * Copyright 2011-2013 Xeiam LLC.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.xeiam.xchart.demo.charts;

import java.awt.Color;
import java.awt.Font;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Locale;

import com.xeiam.xchart.Chart;
import com.xeiam.xchart.ChartColor;
import com.xeiam.xchart.Series;
import com.xeiam.xchart.SeriesColor;
import com.xeiam.xchart.SeriesLineStyle;
import com.xeiam.xchart.SeriesMarker;
import com.xeiam.xchart.SwingWrapper;

/**
 * Extensive chart customization
 * 
 * @author timmolter
 */
public class Example9 implements ExampleChart {

  public static void main(String[] args) {

    ExampleChart exampleChart = new Example9();
    Chart chart = exampleChart.getChart();
    new SwingWrapper(chart).displayChart();
  }

  @Override
  public Chart getChart() {

    // Create Chart
    Chart chart = new Chart(800, 600);

    // generates linear data
    Collection<Date> xData = new ArrayList<Date>();
    Collection<Number> yData = new ArrayList<Number>();

    DateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
    Date date = null;
    for (int i = 1; i <= 10; i++) {

      try {
        date = sdf.parse(i + ".10.2008");
      } catch (ParseException e) {
        e.printStackTrace();
      }
      xData.add(date);
      yData.add(Math.random() * i);
    }

    // Customize Chart
    chart.setTitle("Sample Chart Extensive Cusomization");
    chart.setXAxisTitle("X");
    chart.setYAxisTitle("Y");
    chart.setForegroundColor(ChartColor.getAWTColor(ChartColor.GREY));
    chart.setGridLinesColor(new Color(255, 255, 255));
    chart.setBackgroundColor(Color.WHITE);
    chart.setLegendBackgroundColor(Color.PINK);
    chart.setLinesColor(Color.GREEN);
    chart.setFontColor(Color.MAGENTA);
    chart.setTitleFont(new Font(Font.MONOSPACED, Font.BOLD, 24));
    chart.setLegendFont(new Font(Font.SERIF, Font.PLAIN, 18));
    chart.setAxisTitleFont(new Font(Font.SANS_SERIF, Font.ITALIC, 18));
    chart.setTickLabelFont(new Font(Font.SANS_SERIF, Font.ITALIC, 18));
    chart.setTickLabelFont(new Font(Font.SERIF, Font.PLAIN, 11));
    chart.setDateFormatter("dd-MMM");
    chart.setDecmialFormatter("#.000");
    chart.setLocale(Locale.GERMAN);

    Series series = chart.addDateSeries("Fake Data", xData, yData);
    series.setLineColor(SeriesColor.BLUE);
    series.setMarkerColor(Color.ORANGE);
    series.setMarker(SeriesMarker.CIRCLE);
    series.setLineStyle(SeriesLineStyle.SOLID);

    return chart;
  }

}
