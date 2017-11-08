package com.kittyapp.dataaccess.entities;

import java.time.ZonedDateTime;

/**
 * 
 * <ul>
 * <li><b>Title</b> : Transaction.java</li>
 * <li><b>Description</b> :</li>
 * <li><b>Copyright</b> : Copyright (c) 2017</li>
 * <li><b>Company</b> : Siemens Traffic</li>
 * <li><b>Project</b> : kittyapp</li>
 * <li><b>Author</b> : Mike.Shiner</li>
 * </ul>
 * <p>
 * Copyright (c) Siemens plc 2017. This is an unpublished work, the copyright in which vests in Siemens plc. All
 * rights reserved. <br/>
 * The information contained herein is the property of Siemens plc and is supplied without liability for any errors or
 * omissions and no part may be copied,<br>
 * reproduced, used or disclosed except as authorised by contract or other prior written permission. <br/>
 * The copyright and the foregoing restriction on reproduction, use and disclosure extend to all the media in which this
 * information may be embodied. <br/>
 * Where any information is the responsibility of individual authors, the views contained within said documents do not
 * necessarily represent the views of Siemens plc.
 * </p>
 */
public class Transaction
{
    private String description;
    private String type;
    private String location;
    private double cost;
    private ZonedDateTime timestamp;
    private ZonedDateTime createdTimestamp;
}
