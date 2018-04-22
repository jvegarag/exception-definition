/*
 *  $Id$
 *       . * .
 *     * RRRR  *    Copyright (c) 2015 OHIM: Office for Harmonization
 *   .   RR  R   .  in the Internal Market (trade marks and designs)
 *   *   RRR     *
 *    .  RR RR  .   ALL RIGHTS RESERVED
 *     * . _ . *
 */
//@formatter:on

package com.jvegarag.exception.definition.errors.enums;

/**
 * The Enum Severity.
 */
public enum Severity {
	//@formatter:off
	
	/** It is intended to turn off logging. **/
	OFF,      
	
	/** Detailed information on the flow through the system **/
    DEBUG,    
    
    /** Interesting runtime events **/
    INFO,     
    
    /** Warning message **/
    WARN,     
    
    /** Runtime errors or unexpected conditions  **/
    ERROR     
	
	//@formatter:on
}
