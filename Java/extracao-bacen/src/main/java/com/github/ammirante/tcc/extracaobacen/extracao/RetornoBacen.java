package com.github.ammirante.tcc.extracaobacen.extracao;

import java.util.List;

import javax.json.bind.annotation.JsonbCreator;
import javax.json.bind.annotation.JsonbProperty;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * RetornoBacen
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class RetornoBacen {

	@JsonProperty("TotalRows")
	private Integer totalRows;
	
	@JsonProperty("RowCount")
	private Integer rowCount;
	
	@JsonProperty("Rows")
	private List<Normativo> rows;
	
	public RetornoBacen() {
		
	}
	
	/**
	 * @param totalRows
	 * @param rowCount
	 * @param rows
	 */
	public RetornoBacen(Integer totalRows, Integer rowCount, List<Normativo> rows) {
		this.totalRows = totalRows;
		this.rowCount = rowCount;
		this.rows = rows;
	}
	
    /**
     * @param totalRows
     * @param rowCount
     * @param row
     * @return
     */
    @JsonbCreator
    public static RetornoBacen of(@JsonbProperty("TotalRows") Integer totalRows, @JsonbProperty("RowCount") Integer rowCount, @JsonbProperty("Rows") List<Normativo> row) {
        return new RetornoBacen(totalRows, rowCount, row);
    }

	/**
	 * @return the totalRows
	 */
	public Integer getTotalRows() {
		return totalRows;
	}

	/**
	 * @return the rowCount
	 */
	public Integer getRowCount() {
		return rowCount;
	}

	/**
	 * @return the rows
	 */
	public List<Normativo> getRows() {
		return rows;
	}

	/**
	 *
	 */
	@Override
	public String toString() {
		return "RetornoBacen [totalRows=" + totalRows + ", rowCount=" + rowCount + ", rows=" + rows + "]";
	}
}
