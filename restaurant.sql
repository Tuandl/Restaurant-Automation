USE [restaurant]
GO
/****** Object:  Table [dbo].[table]    Script Date: 07/08/2017 11:00:21 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[table](
	[id] [varchar](10) NOT NULL,
	[status] [nvarchar](20) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[table] DISABLE CHANGE_TRACKING
GO
SET ANSI_PADDING OFF
GO
INSERT [dbo].[table] ([id], [status]) VALUES (N'TB001', N'1')
INSERT [dbo].[table] ([id], [status]) VALUES (N'TB002', N'1')
INSERT [dbo].[table] ([id], [status]) VALUES (N'TB003', N'3')
INSERT [dbo].[table] ([id], [status]) VALUES (N'TB004', N'4')
/****** Object:  Table [dbo].[staff]    Script Date: 07/08/2017 11:00:21 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[staff](
	[id] [varchar](10) NOT NULL,
	[name] [nvarchar](50) NULL,
	[gender] [nvarchar](10) NULL,
	[role] [nvarchar](20) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[staff] DISABLE CHANGE_TRACKING
GO
SET ANSI_PADDING OFF
GO
INSERT [dbo].[staff] ([id], [name], [gender], [role]) VALUES (N'BB001', N'Lê Hiệp', N'Nam', N'Bus Boy')
INSERT [dbo].[staff] ([id], [name], [gender], [role]) VALUES (N'BB002', N'Hoàng Nam', N'Nam', N'Bus Boy')
INSERT [dbo].[staff] ([id], [name], [gender], [role]) VALUES (N'CH001', N'Trần Lý', N'Nữ', N'Chef')
INSERT [dbo].[staff] ([id], [name], [gender], [role]) VALUES (N'CH002', N'Nguyễn Hiệp', N'Nam', N'Chef')
INSERT [dbo].[staff] ([id], [name], [gender], [role]) VALUES (N'MA001', N'Võ Tuấn', N'Nam', N'Manager')
INSERT [dbo].[staff] ([id], [name], [gender], [role]) VALUES (N'WT001', N'Lê Văn Hoàng', N'Nam', N'Waiter')
INSERT [dbo].[staff] ([id], [name], [gender], [role]) VALUES (N'WT002', N'Trần Văn Hưng', N'Nam', N'Waiter')
INSERT [dbo].[staff] ([id], [name], [gender], [role]) VALUES (N'WT003', N'Nguyễn Văn Tí', N'Nam', N'Waiter')
INSERT [dbo].[staff] ([id], [name], [gender], [role]) VALUES (N'WT004', N'Nguyễn Hương', N'Nữ', N'Waiter')
/****** Object:  Table [dbo].[food]    Script Date: 07/08/2017 11:00:21 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[food](
	[id] [varchar](10) NOT NULL,
	[name] [nvarchar](50) NULL,
	[price] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[food] DISABLE CHANGE_TRACKING
GO
SET ANSI_PADDING OFF
GO
INSERT [dbo].[food] ([id], [name], [price]) VALUES (N'FO001', N'Cơm chiên dương châu', 30000)
INSERT [dbo].[food] ([id], [name], [price]) VALUES (N'FO002', N'Gà tiềm thuốc bắc', 300000)
INSERT [dbo].[food] ([id], [name], [price]) VALUES (N'FO003', N'Gà kho xả', 270000)
INSERT [dbo].[food] ([id], [name], [price]) VALUES (N'FO004', N'Phở Bò', 30000)
INSERT [dbo].[food] ([id], [name], [price]) VALUES (N'FO005', N'Bún riêu', 20000)
INSERT [dbo].[food] ([id], [name], [price]) VALUES (N'FO006', N'Cá kho tiêu', 15000)
INSERT [dbo].[food] ([id], [name], [price]) VALUES (N'FO007', N'Gà hấp lá chanh', 250000)
INSERT [dbo].[food] ([id], [name], [price]) VALUES (N'FO008', N'Cơm rang cải bò', 35000)
INSERT [dbo].[food] ([id], [name], [price]) VALUES (N'FO009', N'Lẩu thái', 150000)
INSERT [dbo].[food] ([id], [name], [price]) VALUES (N'FO010', N'Món gì đấy', 120000)
/****** Object:  Table [dbo].[tablestatuschange]    Script Date: 07/08/2017 11:00:21 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[tablestatuschange](
	[id] [varchar](10) NOT NULL,
	[staffid] [varchar](10) NULL,
	[tableid] [varchar](10) NULL,
	[status] [nvarchar](20) NULL,
	[time] [datetime] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[tablestatuschange] DISABLE CHANGE_TRACKING
GO
SET ANSI_PADDING OFF
GO
INSERT [dbo].[tablestatuschange] ([id], [staffid], [tableid], [status], [time]) VALUES (N'CH001', N'WT001', N'TB001', N'Có khách', CAST(0x0000A82300754770 AS DateTime))
INSERT [dbo].[tablestatuschange] ([id], [staffid], [tableid], [status], [time]) VALUES (N'CH002', N'WT001', N'TB001', N'Bẩn', CAST(0x0000A8230087F4B0 AS DateTime))
INSERT [dbo].[tablestatuschange] ([id], [staffid], [tableid], [status], [time]) VALUES (N'CH003', N'BB001', N'TB001', N'Sẵn Sàng', CAST(0x0000A82300888150 AS DateTime))
INSERT [dbo].[tablestatuschange] ([id], [staffid], [tableid], [status], [time]) VALUES (N'CH004', N'WT004', N'TB002', N'Có khách', CAST(0x0000A841007FB750 AS DateTime))
INSERT [dbo].[tablestatuschange] ([id], [staffid], [tableid], [status], [time]) VALUES (N'CH005', N'WT004', N'TB002', N'Bẩn', CAST(0x0000A84100963CF0 AS DateTime))
INSERT [dbo].[tablestatuschange] ([id], [staffid], [tableid], [status], [time]) VALUES (N'CH006', N'BB002', N'TB002', N'Sẵn Sàng', CAST(0x0000A84100968340 AS DateTime))
INSERT [dbo].[tablestatuschange] ([id], [staffid], [tableid], [status], [time]) VALUES (N'CH007', N'WT001', N'TB004', N'Có khách', CAST(0x0000A841008462A0 AS DateTime))
INSERT [dbo].[tablestatuschange] ([id], [staffid], [tableid], [status], [time]) VALUES (N'CH008', N'WT001', N'TB004', N'Bẩn', CAST(0x0000A84100ABA950 AS DateTime))
INSERT [dbo].[tablestatuschange] ([id], [staffid], [tableid], [status], [time]) VALUES (N'CH009', N'BB002', N'TB004', N'Sẵn Sàng', CAST(0x0000A84100ACC290 AS DateTime))
INSERT [dbo].[tablestatuschange] ([id], [staffid], [tableid], [status], [time]) VALUES (N'CH010', N'WT002', N'TB004', N'Có khách', CAST(0x0000A84100921E40 AS DateTime))
INSERT [dbo].[tablestatuschange] ([id], [staffid], [tableid], [status], [time]) VALUES (N'CH011', N'WT002', N'TB004', N'Bẩn', CAST(0x0000A841009E7A50 AS DateTime))
INSERT [dbo].[tablestatuschange] ([id], [staffid], [tableid], [status], [time]) VALUES (N'CH012', N'WT003', N'TB003', N'Có khách', CAST(0x0000A8410098FC10 AS DateTime))
/****** Object:  Table [dbo].[order]    Script Date: 07/08/2017 11:00:21 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[order](
	[id] [varchar](10) NOT NULL,
	[tableid] [varchar](10) NULL,
	[waiterid] [varchar](10) NULL,
	[status] [nvarchar](20) NULL,
	[starttime] [datetime] NULL,
	[endtime] [datetime] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[order] DISABLE CHANGE_TRACKING
GO
SET ANSI_PADDING OFF
GO
INSERT [dbo].[order] ([id], [tableid], [waiterid], [status], [starttime], [endtime]) VALUES (N'OR001', N'TB001', N'WT001', N'Đã thanh toán', CAST(0x0000A82300754770 AS DateTime), CAST(0x0000A8230087F4B0 AS DateTime))
INSERT [dbo].[order] ([id], [tableid], [waiterid], [status], [starttime], [endtime]) VALUES (N'OR002', N'TB002', N'WT004', N'Đã thanh toán', CAST(0x0000A841007FB750 AS DateTime), CAST(0x0000A84100963CF0 AS DateTime))
INSERT [dbo].[order] ([id], [tableid], [waiterid], [status], [starttime], [endtime]) VALUES (N'OR003', N'TB004', N'WT001', N'Đã thanh toán', CAST(0x0000A841008462A0 AS DateTime), CAST(0x0000A84100ABA950 AS DateTime))
INSERT [dbo].[order] ([id], [tableid], [waiterid], [status], [starttime], [endtime]) VALUES (N'OR004', N'TB004', N'WT002', N'Đã thanh toán', CAST(0x0000A84100921E40 AS DateTime), CAST(0x0000A841009E7A50 AS DateTime))
INSERT [dbo].[order] ([id], [tableid], [waiterid], [status], [starttime], [endtime]) VALUES (N'OR005', N'TB003', N'WT003', N'Chưa thanh toán', CAST(0x0000A8410098FC10 AS DateTime), CAST(0x0000A84100ABA950 AS DateTime))
/****** Object:  Table [dbo].[orderdetail]    Script Date: 07/08/2017 11:00:21 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[orderdetail](
	[code] [varchar](10) NOT NULL,
	[orderid] [varchar](10) NULL,
	[foodid] [varchar](10) NULL,
	[quantity] [int] NULL,
	[ordertime] [datetime] NULL,
	[readytime] [datetime] NULL,
	[chefid] [varchar](10) NULL,
	[status] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[code] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[orderdetail] DISABLE CHANGE_TRACKING
GO
SET ANSI_PADDING OFF
GO
INSERT [dbo].[orderdetail] ([code], [orderid], [foodid], [quantity], [ordertime], [readytime], [chefid], [status]) VALUES (N'', NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[orderdetail] ([code], [orderid], [foodid], [quantity], [ordertime], [readytime], [chefid], [status]) VALUES (N'OD001', N'OR001', N'FO003', 2, CAST(0x0000A82300758DC0 AS DateTime), CAST(0x0000A823007779F0 AS DateTime), N'CH001', N'1')
INSERT [dbo].[orderdetail] ([code], [orderid], [foodid], [quantity], [ordertime], [readytime], [chefid], [status]) VALUES (N'OD002', N'OR001', N'FO001', 1, CAST(0x0000A82300758DC0 AS DateTime), CAST(0x0000A82300789330 AS DateTime), N'CH002', N'2')
INSERT [dbo].[orderdetail] ([code], [orderid], [foodid], [quantity], [ordertime], [readytime], [chefid], [status]) VALUES (N'OD003', N'OR001', N'FO002', 1, CAST(0x0000A8230075D410 AS DateTime), CAST(0x0000A823007779F0 AS DateTime), N'CH001', N'3')
INSERT [dbo].[orderdetail] ([code], [orderid], [foodid], [quantity], [ordertime], [readytime], [chefid], [status]) VALUES (N'OD004', N'OR002', N'FO007', 4, CAST(0x0000A841007FFDA0 AS DateTime), CAST(0x0000A84100827670 AS DateTime), N'CH001', N'4')
INSERT [dbo].[orderdetail] ([code], [orderid], [foodid], [quantity], [ordertime], [readytime], [chefid], [status]) VALUES (N'OD005', N'OR002', N'FO002', 1, CAST(0x0000A8410080D090 AS DateTime), CAST(0x0000A841008462A0 AS DateTime), N'CH002', N'1')
INSERT [dbo].[orderdetail] ([code], [orderid], [foodid], [quantity], [ordertime], [readytime], [chefid], [status]) VALUES (N'OD006', N'OR003', N'FO004', 3, CAST(0x0000A84100853590 AS DateTime), CAST(0x0000A84100888150 AS DateTime), N'CH001', N'2')
INSERT [dbo].[orderdetail] ([code], [orderid], [foodid], [quantity], [ordertime], [readytime], [chefid], [status]) VALUES (N'OD007', N'OR003', N'FO005', 5, CAST(0x0000A8410085C230 AS DateTime), CAST(0x0000A841008BCD10 AS DateTime), N'CH002', N'3')
INSERT [dbo].[orderdetail] ([code], [orderid], [foodid], [quantity], [ordertime], [readytime], [chefid], [status]) VALUES (N'OD008', N'OR004', N'FO009', 2, CAST(0x0000A8410092F130 AS DateTime), CAST(0x0000A84100963CF0 AS DateTime), N'CH002', N'4')
INSERT [dbo].[orderdetail] ([code], [orderid], [foodid], [quantity], [ordertime], [readytime], [chefid], [status]) VALUES (N'OD009', N'OR004', N'FO003', 1, CAST(0x0000A84100926490 AS DateTime), CAST(0x0000A841009A5BA0 AS DateTime), N'CH002', N'1')
INSERT [dbo].[orderdetail] ([code], [orderid], [foodid], [quantity], [ordertime], [readytime], [chefid], [status]) VALUES (N'OD010', N'OR005', N'FO005', 1, CAST(0x0000A84100994260 AS DateTime), CAST(0x0000A841009BBB30 AS DateTime), N'CH001', N'2')
INSERT [dbo].[orderdetail] ([code], [orderid], [foodid], [quantity], [ordertime], [readytime], [chefid], [status]) VALUES (N'OD011', N'OR005', N'FO002', 1, CAST(0x0000A8410099CF00 AS DateTime), CAST(0x0000A841009DEDB0 AS DateTime), N'CH001', N'3')
/****** Object:  ForeignKey [FK__order__tableid__1273C1CD]    Script Date: 07/08/2017 11:00:21 ******/
ALTER TABLE [dbo].[order]  WITH CHECK ADD FOREIGN KEY([tableid])
REFERENCES [dbo].[table] ([id])
GO
/****** Object:  ForeignKey [FK__order__waiterid__1367E606]    Script Date: 07/08/2017 11:00:21 ******/
ALTER TABLE [dbo].[order]  WITH CHECK ADD FOREIGN KEY([waiterid])
REFERENCES [dbo].[staff] ([id])
GO
/****** Object:  ForeignKey [FK__orderdeta__chefi__2C3393D0]    Script Date: 07/08/2017 11:00:21 ******/
ALTER TABLE [dbo].[orderdetail]  WITH CHECK ADD FOREIGN KEY([chefid])
REFERENCES [dbo].[staff] ([id])
GO
/****** Object:  ForeignKey [FK__orderdeta__foodi__1ED998B2]    Script Date: 07/08/2017 11:00:21 ******/
ALTER TABLE [dbo].[orderdetail]  WITH CHECK ADD FOREIGN KEY([foodid])
REFERENCES [dbo].[food] ([id])
GO
/****** Object:  ForeignKey [FK__orderdeta__order__1DE57479]    Script Date: 07/08/2017 11:00:21 ******/
ALTER TABLE [dbo].[orderdetail]  WITH CHECK ADD FOREIGN KEY([orderid])
REFERENCES [dbo].[order] ([id])
GO
/****** Object:  ForeignKey [FK__tablestat__staff__08EA5793]    Script Date: 07/08/2017 11:00:21 ******/
ALTER TABLE [dbo].[tablestatuschange]  WITH CHECK ADD FOREIGN KEY([staffid])
REFERENCES [dbo].[staff] ([id])
GO
/****** Object:  ForeignKey [FK__tablestat__table__09DE7BCC]    Script Date: 07/08/2017 11:00:21 ******/
ALTER TABLE [dbo].[tablestatuschange]  WITH CHECK ADD FOREIGN KEY([tableid])
REFERENCES [dbo].[table] ([id])
GO
