
package com.cyberwith.hometask.models;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Report {

    @SerializedName("error")
    @Expose
    private Integer error;
    @SerializedName("error_report")
    @Expose
    private String errorReport;
    @SerializedName("report")
    @Expose
    private List<ReportListModel> reportListModel = null;

    public Integer getError() {
        return error;
    }

    public void setError(Integer error) {
        this.error = error;
    }

    public String getErrorReport() {
        return errorReport;
    }

    public void setErrorReport(String errorReport) {
        this.errorReport = errorReport;
    }

    public List<ReportListModel> getReportListModel() {
        return reportListModel;
    }

    public void setReportListModel(List<ReportListModel> reportListModel) {
        this.reportListModel = reportListModel;
    }

}
