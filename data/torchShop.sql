USE [master]
GO
/****** Object:  Database [QuanLyBanGiayDep]    Script Date: 7/27/2024 8:33:03 PM ******/
CREATE DATABASE [QuanLyBanGiayDep]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'QuanLyBanGiayDep', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.SQLEXPRESS\MSSQL\DATA\QuanLyBanGiayDep.mdf' , SIZE = 3264KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'QuanLyBanGiayDep_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.SQLEXPRESS\MSSQL\DATA\QuanLyBanGiayDep_log.ldf' , SIZE = 832KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [QuanLyBanGiayDep] SET COMPATIBILITY_LEVEL = 120
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [QuanLyBanGiayDep].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [QuanLyBanGiayDep] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [QuanLyBanGiayDep] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [QuanLyBanGiayDep] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [QuanLyBanGiayDep] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [QuanLyBanGiayDep] SET ARITHABORT OFF 
GO
ALTER DATABASE [QuanLyBanGiayDep] SET AUTO_CLOSE ON 
GO
ALTER DATABASE [QuanLyBanGiayDep] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [QuanLyBanGiayDep] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [QuanLyBanGiayDep] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [QuanLyBanGiayDep] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [QuanLyBanGiayDep] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [QuanLyBanGiayDep] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [QuanLyBanGiayDep] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [QuanLyBanGiayDep] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [QuanLyBanGiayDep] SET  ENABLE_BROKER 
GO
ALTER DATABASE [QuanLyBanGiayDep] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [QuanLyBanGiayDep] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [QuanLyBanGiayDep] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [QuanLyBanGiayDep] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [QuanLyBanGiayDep] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [QuanLyBanGiayDep] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [QuanLyBanGiayDep] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [QuanLyBanGiayDep] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [QuanLyBanGiayDep] SET  MULTI_USER 
GO
ALTER DATABASE [QuanLyBanGiayDep] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [QuanLyBanGiayDep] SET DB_CHAINING OFF 
GO
ALTER DATABASE [QuanLyBanGiayDep] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [QuanLyBanGiayDep] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
ALTER DATABASE [QuanLyBanGiayDep] SET DELAYED_DURABILITY = DISABLED 
GO
USE [QuanLyBanGiayDep]
GO
/****** Object:  Table [dbo].[Account]    Script Date: 7/27/2024 8:33:03 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Account](
	[uID] [int] IDENTITY(1,1) NOT NULL,
	[username] [nchar](20) NOT NULL,
	[password] [nchar](20) NOT NULL,
	[email] [nvarchar](50) NULL,
	[isAdmin] [bit] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[uID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Brand]    Script Date: 7/27/2024 8:33:03 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Brand](
	[bID] [int] IDENTITY(1,1) NOT NULL,
	[bName] [nvarchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[bID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Cart]    Script Date: 7/27/2024 8:33:03 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Cart](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[accountID] [int] NULL,
	[productVariantID] [int] NULL,
	[amount] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Category]    Script Date: 7/27/2024 8:33:03 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Category](
	[cID] [int] IDENTITY(1,1) NOT NULL,
	[cName] [nvarchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[cID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Invoice]    Script Date: 7/27/2024 8:33:03 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Invoice](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[accountID] [int] NULL,
	[date] [datetime] NULL,
	[totalPrice] [float] NULL,
	[customerName] [nvarchar](50) NULL,
	[phoneNumber] [nvarchar](10) NULL,
	[address] [nvarchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[InvoiceDetail]    Script Date: 7/27/2024 8:33:03 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[InvoiceDetail](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[productVariantID] [int] NULL,
	[amount] [int] NULL,
	[totalPrice] [float] NULL,
	[invoiceID] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Product]    Script Date: 7/27/2024 8:33:03 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Product](
	[id] [varchar](10) NOT NULL,
	[name] [nvarchar](50) NULL,
	[image] [nvarchar](500) NULL,
	[price] [float] NULL,
	[retailPrice] [float] NULL,
	[description] [nvarchar](max) NULL,
	[categoryID] [int] NOT NULL,
	[brandID] [int] NOT NULL,
	[supplierID] [int] NOT NULL,
	[gender] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ProductVariant]    Script Date: 7/27/2024 8:33:03 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ProductVariant](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[productID] [varchar](10) NOT NULL,
	[size] [int] NULL,
	[color] [nvarchar](50) NULL,
	[quantity] [int] NULL,
	[soldQuantity] [int] NULL DEFAULT ((0)),
	[image1] [nvarchar](500) NULL,
	[image2] [nvarchar](500) NULL,
	[image3] [nvarchar](500) NULL,
	[image4] [nvarchar](500) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Supplier]    Script Date: 7/27/2024 8:33:03 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Supplier](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[name] [nvarchar](50) NULL,
	[email] [nvarchar](50) NULL,
	[phoneNumber] [nchar](10) NULL,
	[address] [nvarchar](100) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET IDENTITY_INSERT [dbo].[Account] ON 

INSERT [dbo].[Account] ([uID], [username], [password], [email], [isAdmin]) VALUES (1, N'tong                ', N'123456              ', N'tong10092003@gmail.com', 0)
INSERT [dbo].[Account] ([uID], [username], [password], [email], [isAdmin]) VALUES (2, N'tong1               ', N'123456              ', N'tong10092003.1@gmail.com', 0)
INSERT [dbo].[Account] ([uID], [username], [password], [email], [isAdmin]) VALUES (3, N'tong2               ', N'123456              ', N'tong2@gmail.com', 0)
INSERT [dbo].[Account] ([uID], [username], [password], [email], [isAdmin]) VALUES (4, N'admin               ', N'admin               ', N'tong10092003@gmail.com', 1)
INSERT [dbo].[Account] ([uID], [username], [password], [email], [isAdmin]) VALUES (5, N'nguyenvana          ', N'nguyenvana          ', N'nguyenvana@gmail.com', 0)
INSERT [dbo].[Account] ([uID], [username], [password], [email], [isAdmin]) VALUES (6, N'chika               ', N'chika               ', N'chika12@gmail.com', 0)
INSERT [dbo].[Account] ([uID], [username], [password], [email], [isAdmin]) VALUES (7, N'hieuluc             ', N'123456              ', N'luc222@gmail.com', 0)
SET IDENTITY_INSERT [dbo].[Account] OFF
SET IDENTITY_INSERT [dbo].[Brand] ON 

INSERT [dbo].[Brand] ([bID], [bName]) VALUES (1, N'Nike')
INSERT [dbo].[Brand] ([bID], [bName]) VALUES (2, N'Adidas')
INSERT [dbo].[Brand] ([bID], [bName]) VALUES (3, N'Puma')
INSERT [dbo].[Brand] ([bID], [bName]) VALUES (4, N'RieNevan')
INSERT [dbo].[Brand] ([bID], [bName]) VALUES (5, N'MLB')
SET IDENTITY_INSERT [dbo].[Brand] OFF
SET IDENTITY_INSERT [dbo].[Category] ON 

INSERT [dbo].[Category] ([cID], [cName]) VALUES (1, N'Giày thể thao')
INSERT [dbo].[Category] ([cID], [cName]) VALUES (2, N'Dép quai ngang')
INSERT [dbo].[Category] ([cID], [cName]) VALUES (3, N'Giày Sandal')
INSERT [dbo].[Category] ([cID], [cName]) VALUES (4, N'Giày Sneaker')
SET IDENTITY_INSERT [dbo].[Category] OFF
SET IDENTITY_INSERT [dbo].[Invoice] ON 

INSERT [dbo].[Invoice] ([id], [accountID], [date], [totalPrice], [customerName], [phoneNumber], [address]) VALUES (1, 1, CAST(N'2024-07-23 00:00:00.000' AS DateTime), 745, N'Đinh Thanh Tòng', N'0366459144', N'S305 Đ. Cầu Vòng, Long Thạnh Mỹ, Quận 9, Hồ Chí Minh')
INSERT [dbo].[Invoice] ([id], [accountID], [date], [totalPrice], [customerName], [phoneNumber], [address]) VALUES (2, 2, CAST(N'2024-07-23 00:00:00.000' AS DateTime), 2065, N'Thắm', N'0344778899', N'12 Nguyễn Văn Bảo, P9, Q. Gò Vấp, Hồ Chí Minh')
INSERT [dbo].[Invoice] ([id], [accountID], [date], [totalPrice], [customerName], [phoneNumber], [address]) VALUES (3, 3, CAST(N'2024-07-25 00:00:00.000' AS DateTime), 590, N'Thắm', N'0344778899', N'12 Nguyễn Văn Bảo, P.16, Quận 9, Hồ Chí Minh')
INSERT [dbo].[Invoice] ([id], [accountID], [date], [totalPrice], [customerName], [phoneNumber], [address]) VALUES (4, 7, CAST(N'2024-07-25 00:00:00.000' AS DateTime), 640, N'Nguyễn Hiếu Lực', N'0399665876', N'123/111, P2, Q3, Thành Phố Hồ Chí Minh')
INSERT [dbo].[Invoice] ([id], [accountID], [date], [totalPrice], [customerName], [phoneNumber], [address]) VALUES (5, 5, CAST(N'2024-07-25 00:00:00.000' AS DateTime), 805, N'Nguyễn Văn A', N'0978969842', N'11/C, Ấp 3, An Phong, Thanh Bình, Đồng Tháp')
INSERT [dbo].[Invoice] ([id], [accountID], [date], [totalPrice], [customerName], [phoneNumber], [address]) VALUES (6, 6, CAST(N'2024-07-25 00:00:00.000' AS DateTime), 620, N'Lê Bình An', N'0325874168', N'9 Phan Chu Trinh, Phường 2, Thành Phố Vũng Tàu, Bà Rịa - Vũng Tàu')
INSERT [dbo].[Invoice] ([id], [accountID], [date], [totalPrice], [customerName], [phoneNumber], [address]) VALUES (7, 1, CAST(N'2024-07-25 00:00:00.000' AS DateTime), 325, N'Đinh Thanh Tòng', N'0366459144', N'S305 Đ. Cầu Vòng, Long Thạnh Mỹ, Quận 9, Hồ Chí Minh')
INSERT [dbo].[Invoice] ([id], [accountID], [date], [totalPrice], [customerName], [phoneNumber], [address]) VALUES (8, 1, CAST(N'2024-07-26 00:00:00.000' AS DateTime), 370, N'Đinh Thanh Tòng', N'0366459144', N'S305 Đ. Cầu Vòng, Long Thạnh Mỹ, Quận 9, Hồ Chí Minh')
INSERT [dbo].[Invoice] ([id], [accountID], [date], [totalPrice], [customerName], [phoneNumber], [address]) VALUES (9, 1, CAST(N'2024-07-26 00:00:00.000' AS DateTime), 435, N'Đinh Thanh Tòng', N'0366459144', N'S305 Đ. Cầu Vòng, Long Thạnh Mỹ, Quận 9, Hồ Chí Minh')
INSERT [dbo].[Invoice] ([id], [accountID], [date], [totalPrice], [customerName], [phoneNumber], [address]) VALUES (10, 6, CAST(N'2024-07-26 00:00:00.000' AS DateTime), 230, N'Mai Chiến Tướng', N'0964785592', N'88 Lê Lai, phường 3, thành phố Vũng Tàu, tỉnh Bà Rịa – Vũng Tàu')
INSERT [dbo].[Invoice] ([id], [accountID], [date], [totalPrice], [customerName], [phoneNumber], [address]) VALUES (11, 2, CAST(N'2024-07-26 00:00:00.000' AS DateTime), 630, N'Đinh Thanh Tòng', N'0366459144', N'S305 Đ. Cầu Vòng, Long Thạnh Mỹ, Quận 9, Hồ Chí Minh')
INSERT [dbo].[Invoice] ([id], [accountID], [date], [totalPrice], [customerName], [phoneNumber], [address]) VALUES (12, 2, CAST(N'2024-07-26 00:00:00.000' AS DateTime), 145, N'Đinh Thanh Tòng', N'0366459144', N'S305 Đ. Cầu Vòng, Long Thạnh Mỹ, Quận 9, Hồ Chí Minh')
SET IDENTITY_INSERT [dbo].[Invoice] OFF
SET IDENTITY_INSERT [dbo].[InvoiceDetail] ON 

INSERT [dbo].[InvoiceDetail] ([id], [productVariantID], [amount], [totalPrice], [invoiceID]) VALUES (1, 18, 2, 290, 1)
INSERT [dbo].[InvoiceDetail] ([id], [productVariantID], [amount], [totalPrice], [invoiceID]) VALUES (2, 23, 1, 105, 1)
INSERT [dbo].[InvoiceDetail] ([id], [productVariantID], [amount], [totalPrice], [invoiceID]) VALUES (3, 21, 2, 350, 1)
INSERT [dbo].[InvoiceDetail] ([id], [productVariantID], [amount], [totalPrice], [invoiceID]) VALUES (4, 16, 2, 170, 2)
INSERT [dbo].[InvoiceDetail] ([id], [productVariantID], [amount], [totalPrice], [invoiceID]) VALUES (5, 11, 1, 135, 2)
INSERT [dbo].[InvoiceDetail] ([id], [productVariantID], [amount], [totalPrice], [invoiceID]) VALUES (6, 2, 2, 310, 2)
INSERT [dbo].[InvoiceDetail] ([id], [productVariantID], [amount], [totalPrice], [invoiceID]) VALUES (7, 17, 5, 725, 2)
INSERT [dbo].[InvoiceDetail] ([id], [productVariantID], [amount], [totalPrice], [invoiceID]) VALUES (8, 18, 5, 725, 2)
INSERT [dbo].[InvoiceDetail] ([id], [productVariantID], [amount], [totalPrice], [invoiceID]) VALUES (9, 32, 2, 180, 3)
INSERT [dbo].[InvoiceDetail] ([id], [productVariantID], [amount], [totalPrice], [invoiceID]) VALUES (10, 28, 2, 240, 3)
INSERT [dbo].[InvoiceDetail] ([id], [productVariantID], [amount], [totalPrice], [invoiceID]) VALUES (11, 16, 2, 170, 3)
INSERT [dbo].[InvoiceDetail] ([id], [productVariantID], [amount], [totalPrice], [invoiceID]) VALUES (12, 31, 2, 180, 4)
INSERT [dbo].[InvoiceDetail] ([id], [productVariantID], [amount], [totalPrice], [invoiceID]) VALUES (13, 15, 2, 170, 4)
INSERT [dbo].[InvoiceDetail] ([id], [productVariantID], [amount], [totalPrice], [invoiceID]) VALUES (14, 19, 2, 290, 4)
INSERT [dbo].[InvoiceDetail] ([id], [productVariantID], [amount], [totalPrice], [invoiceID]) VALUES (15, 25, 2, 240, 5)
INSERT [dbo].[InvoiceDetail] ([id], [productVariantID], [amount], [totalPrice], [invoiceID]) VALUES (16, 35, 1, 90, 5)
INSERT [dbo].[InvoiceDetail] ([id], [productVariantID], [amount], [totalPrice], [invoiceID]) VALUES (17, 10, 5, 475, 5)
INSERT [dbo].[InvoiceDetail] ([id], [productVariantID], [amount], [totalPrice], [invoiceID]) VALUES (18, 2, 2, 310, 6)
INSERT [dbo].[InvoiceDetail] ([id], [productVariantID], [amount], [totalPrice], [invoiceID]) VALUES (19, 9, 2, 310, 6)
INSERT [dbo].[InvoiceDetail] ([id], [productVariantID], [amount], [totalPrice], [invoiceID]) VALUES (20, 47, 5, 325, 7)
INSERT [dbo].[InvoiceDetail] ([id], [productVariantID], [amount], [totalPrice], [invoiceID]) VALUES (21, 48, 2, 130, 8)
INSERT [dbo].[InvoiceDetail] ([id], [productVariantID], [amount], [totalPrice], [invoiceID]) VALUES (22, 15, 1, 85, 8)
INSERT [dbo].[InvoiceDetail] ([id], [productVariantID], [amount], [totalPrice], [invoiceID]) VALUES (23, 9, 1, 155, 8)
INSERT [dbo].[InvoiceDetail] ([id], [productVariantID], [amount], [totalPrice], [invoiceID]) VALUES (24, 27, 3, 360, 9)
INSERT [dbo].[InvoiceDetail] ([id], [productVariantID], [amount], [totalPrice], [invoiceID]) VALUES (25, 36, 1, 75, 9)
INSERT [dbo].[InvoiceDetail] ([id], [productVariantID], [amount], [totalPrice], [invoiceID]) VALUES (26, 45, 2, 80, 10)
INSERT [dbo].[InvoiceDetail] ([id], [productVariantID], [amount], [totalPrice], [invoiceID]) VALUES (27, 42, 2, 150, 10)
INSERT [dbo].[InvoiceDetail] ([id], [productVariantID], [amount], [totalPrice], [invoiceID]) VALUES (28, 12, 2, 550, 11)
INSERT [dbo].[InvoiceDetail] ([id], [productVariantID], [amount], [totalPrice], [invoiceID]) VALUES (29, 43, 1, 40, 11)
INSERT [dbo].[InvoiceDetail] ([id], [productVariantID], [amount], [totalPrice], [invoiceID]) VALUES (30, 44, 1, 40, 11)
INSERT [dbo].[InvoiceDetail] ([id], [productVariantID], [amount], [totalPrice], [invoiceID]) VALUES (31, 17, 1, 145, 12)
SET IDENTITY_INSERT [dbo].[InvoiceDetail] OFF
INSERT [dbo].[Product] ([id], [name], [image], [price], [retailPrice], [description], [categoryID], [brandID], [supplierID], [gender]) VALUES (N'SP0001', N'Air Jordan 1 Low', N'https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,q_auto:eco,u_126ab356-44d8-4a06-89b4-fcdcc8df0245,c_scale,fl_relative,w_1.0,h_1.0,fl_layer_apply/1c0c434c-9802-4556-89c7-a8600b2828d8/air-jordan-1-low-shoes-lFCSjp.png', 130, 155, N'Giày Sneaker Nam hiện đại', 4, 1, 1, 1)
INSERT [dbo].[Product] ([id], [name], [image], [price], [retailPrice], [description], [categoryID], [brandID], [supplierID], [gender]) VALUES (N'SP0002', N'Air Force 1', N'https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,q_auto:eco/7393b8e2-4350-45c1-bc82-2c83f7cd3777/air-force-1-07-easyon-shoes-LKXPhZ.png', 85, 105, N'Giày Sneaker Nam hiện đại', 4, 1, 1, -1)
INSERT [dbo].[Product] ([id], [name], [image], [price], [retailPrice], [description], [categoryID], [brandID], [supplierID], [gender]) VALUES (N'SP0003', N'Court Vision Low', N'https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,q_auto:eco/cf43fd2a-f2c3-4d7e-ae24-65bd6e0c41c1/court-vision-low-shoes-ZwjLXN.png', 144, 165, N'Giày Sneaker Nam hiện đại', 4, 1, 1, 1)
INSERT [dbo].[Product] ([id], [name], [image], [price], [retailPrice], [description], [categoryID], [brandID], [supplierID], [gender]) VALUES (N'SP0004', N'Blazer Mid', N'https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,q_auto:eco/057482ba-4077-40a4-aa18-ef8f1b8f4fcf/blazer-mid-77-vintage-shoes-dNWPTj.png', 160, 185, N'Giày Sneaker Nam hiện đại cổ cao', 4, 1, 1, 1)
INSERT [dbo].[Product] ([id], [name], [image], [price], [retailPrice], [description], [categoryID], [brandID], [supplierID], [gender]) VALUES (N'SP0005', N'Jordan Stadium', N'https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,q_auto:eco,u_126ab356-44d8-4a06-89b4-fcdcc8df0245,c_scale,fl_relative,w_1.0,h_1.0,fl_layer_apply/69945194-72f0-4d2a-aa2c-db8dc5da2379/jordan-stadium-90-shoes-Jn6ZH4.png', 122, 155, N'Giày thể thao', 1, 1, 1, 1)
INSERT [dbo].[Product] ([id], [name], [image], [price], [retailPrice], [description], [categoryID], [brandID], [supplierID], [gender]) VALUES (N'SP0006', N'Samba OG', N'https://assets.adidas.com/images/h_840,f_auto,q_auto,fl_lossy,c_fill,g_auto/3bbecbdf584e40398446a8bf0117cf62_9366/Samba_OG_Shoes_White_B75806_01_standard.jpg', 80, 95, N'Giày Sneaker add', 4, 2, 1, -1)
INSERT [dbo].[Product] ([id], [name], [image], [price], [retailPrice], [description], [categoryID], [brandID], [supplierID], [gender]) VALUES (N'SP0007', N'Forum Low CL', N'https://assets.adidas.com/images/h_840,f_auto,q_auto,fl_lossy,c_fill,g_auto/4875ee034a57417da114af623cfd5ff9_9366/Forum_Low_CL_Shoes_White_IH7907_01_standard.jpg', 112, 135, N'Giày thể thao', 1, 2, 1, -1)
INSERT [dbo].[Product] ([id], [name], [image], [price], [retailPrice], [description], [categoryID], [brandID], [supplierID], [gender]) VALUES (N'SP0008', N'Campus', N'https://assets.adidas.com/images/h_840,f_auto,q_auto,fl_lossy,c_fill,g_auto/ce738cbe5342421996feaf5001044964_9366/Campus_00s_Shoes_Grey_HQ8707_01_standard.jpg', 250, 275, N'Giày thể thao', 1, 2, 1, 1)
INSERT [dbo].[Product] ([id], [name], [image], [price], [retailPrice], [description], [categoryID], [brandID], [supplierID], [gender]) VALUES (N'SP0009', N'Handball Spezial', N'https://assets.adidas.com/images/h_840,f_auto,q_auto,fl_lossy,c_fill,g_auto/1fa18f47b66e4f4980ba74d48de04ecc_9366/Handball_Spezial_Shoes_Blue_IF7087_01_standard.jpg', 145, 165, N'Giày thể thao', 1, 2, 1, -1)
INSERT [dbo].[Product] ([id], [name], [image], [price], [retailPrice], [description], [categoryID], [brandID], [supplierID], [gender]) VALUES (N'SP0010', N'Stan Smith Decon', N'https://assets.adidas.com/images/h_840,f_auto,q_auto,fl_lossy,c_fill,g_auto/c5e70fd8b9c94502b05b0ffd1d4cf4ac_9366/Stan_Smith_Decon_Shoes_White_IE9118_01_standard.jpg', 133, 155, N'Giày Sneaker ADD HD', 4, 2, 1, 1)
INSERT [dbo].[Product] ([id], [name], [image], [price], [retailPrice], [description], [categoryID], [brandID], [supplierID], [gender]) VALUES (N'SP0011', N'Jordan Jumpman', N'https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,q_auto:eco,u_126ab356-44d8-4a06-89b4-fcdcc8df0245,c_scale,fl_relative,w_1.0,h_1.0,fl_layer_apply/c2a2424b-4d35-490d-9d67-55c2c929e405/jordan-jumpman-slides-2C5ffD.png', 70, 85, N'Dép', 2, 1, 1, 1)
INSERT [dbo].[Product] ([id], [name], [image], [price], [retailPrice], [description], [categoryID], [brandID], [supplierID], [gender]) VALUES (N'SP0012', N'Air 1 low SE', N'https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,q_auto:eco,u_126ab356-44d8-4a06-89b4-fcdcc8df0245,c_scale,fl_relative,w_1.0,h_1.0,fl_layer_apply/eb565318-308f-40bc-b9da-1db2cf863cc3/air-jordan-1-low-se-shoes-thpSD9.png', 122, 145, N'Giày Sneaker ĐẸP', 4, 1, 1, 0)
INSERT [dbo].[Product] ([id], [name], [image], [price], [retailPrice], [description], [categoryID], [brandID], [supplierID], [gender]) VALUES (N'SP0013', N'Nike Mercurial Vapor 15 Academy', N'https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,q_auto:eco/13945817-d8fd-4ccf-9084-740b0fd657f4/mercurial-vapor-15-academy-mg-low-top-football-boot-DBh36g.png', 150, 175, N'Giày đá bóng', 1, 1, 1, 1)
INSERT [dbo].[Product] ([id], [name], [image], [price], [retailPrice], [description], [categoryID], [brandID], [supplierID], [gender]) VALUES (N'SP0014', N'Terres Hydroterra Sandals', N'https://assets.adidas.com/images/h_840,f_auto,q_auto,fl_lossy,c_fill,g_auto/23f55dafcfbf45e1a1ba5191c4886175_9366/TERREX_Hydroterra_Sandals_Black_IF7596_01_standard.jpg', 80, 105, N'Giày Sandals', 3, 2, 1, 1)
INSERT [dbo].[Product] ([id], [name], [image], [price], [retailPrice], [description], [categoryID], [brandID], [supplierID], [gender]) VALUES (N'SP0015', N'FENTY x PUMA Creeper Phatty', N'https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_2000,h_2000/global/399870/04/sv01/fnd/PNA/fmt/png/FENTY-x-PUMA-Creeper-Phatty-In-Session-Men''s-Sneakers', 93, 120, N'', 4, 3, 2, 1)
INSERT [dbo].[Product] ([id], [name], [image], [price], [retailPrice], [description], [categoryID], [brandID], [supplierID], [gender]) VALUES (N'SP0016', N'Palermo Vintage Sneakers', N'https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_600,h_600/global/396841/01/sv01/fnd/PNA/fmt/png/Palermo-Vintage-Sneakers', 60, 90, N'Straight from our archives, it''s the PUMA Palermo. This classic terrace shoe debuted in the 80''s and now', 4, 3, 2, 0)
INSERT [dbo].[Product] ([id], [name], [image], [price], [retailPrice], [description], [categoryID], [brandID], [supplierID], [gender]) VALUES (N'SP0017', N'LOVE MARATHON', N'https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_600,h_600/global/395830/01/sv01/fnd/PNA/fmt/png/LOVE-MARATHON-Suede-Sneakers', 50, 75, N'Show your pride with the Love Marathon collection from PUMA. Created to celebrate and honor the LGBTQ+ community', 1, 3, 2, -1)
INSERT [dbo].[Product] ([id], [name], [image], [price], [retailPrice], [description], [categoryID], [brandID], [supplierID], [gender]) VALUES (N'SP0018', N'PLAYER-1 - VOLCANO', N'https://product.hstatic.net/200000536779/product/player-1-red1_7b49d2c2f4a04d7980bbaf893c87b990_master.png', 20, 40, N'Phong cách “Giày của bố” được mang trở lại xu hướng thiết kế trong những năm trở lại đây, và đã được RieNevan lấy cảm hứng thiết kế cho dòng sản phẩm mới mang tên PLAYER-1, là dòng sản phẩm tiếp theo nằm trong bộ sưu tập “Classick” của RieNevan trong năm 2023 này. Với sự kết hợp dễ dàng cùng đa phong cách thời trang, và tối ưu trọng lượng siêu nhẹ, PLAYER-1 là một sự lựa chọn tuyệt vời để bạn khoe cá tính mỗi ngày.', 1, 4, 4, 1)
INSERT [dbo].[Product] ([id], [name], [image], [price], [retailPrice], [description], [categoryID], [brandID], [supplierID], [gender]) VALUES (N'SP0019', N'SNAP CLASSICK - BLACK GUM', N'https://product.hstatic.net/200000536779/product/snap2_11ac3cd4190e4181bff185f85d15bde4_master.png', 40, 65, N'RieNevan SNAP "Classick" là dòng sản phẩm Trượt ván mới được cải tiến từ phiên bản SNAP tiền nhiệm, ra đời với ý tưởng mang trở lại sự cổ điển từ thập niên 80 cùng với thiết kế đậm chất đường phố. RieNevan SNAP vừa đáp ứng được về độ bền, vững chân cho bộ môn trượt ván và cả những hoạt động thời trang thường ngày, dễ phối với đa phong cách với form dáng cổ điển.', 4, 4, 5, 1)
INSERT [dbo].[Product] ([id], [name], [image], [price], [retailPrice], [description], [categoryID], [brandID], [supplierID], [gender]) VALUES (N'SP0020', N'Deviate NITRO™ 3 FADE', N'https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_600,h_600/global/310474/01/sv01/fnd/PNA/fmt/png/Deviate-NITRO%E2%84%A2-3-FADE-Men''s-Running-Shoes', 120, 160, N'Faster than ever, smoother than before, the Deviate 3 is a super-fast', 1, 3, 3, 1)
SET IDENTITY_INSERT [dbo].[ProductVariant] ON 

INSERT [dbo].[ProductVariant] ([id], [productID], [size], [color], [quantity], [soldQuantity], [image1], [image2], [image3], [image4]) VALUES (1, N'SP0001', 37, N'red', 50, 0, N'https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,q_auto:eco,u_126ab356-44d8-4a06-89b4-fcdcc8df0245,c_scale,fl_relative,w_1.0,h_1.0,fl_layer_apply/1c0c434c-9802-4556-89c7-a8600b2828d8/air-jordan-1-low-shoes-lFCSjp.png', N'https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,q_auto:eco,u_126ab356-44d8-4a06-89b4-fcdcc8df0245,c_scale,fl_relative,w_1.0,h_1.0,fl_layer_apply/7ce75f02-661e-4726-a940-bdcaff08caab/air-jordan-1-low-shoes-lFCSjp.png', N'https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,q_auto:eco,u_126ab356-44d8-4a06-89b4-fcdcc8df0245,c_scale,fl_relative,w_1.0,h_1.0,fl_layer_apply/a21d548e-eb3d-4a1b-a086-fffc780f0e0a/air-jordan-1-low-shoes-lFCSjp.png', N'https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,q_auto:eco,u_126ab356-44d8-4a06-89b4-fcdcc8df0245,c_scale,fl_relative,w_1.0,h_1.0,fl_layer_apply/da34aa91-c3b3-4b50-95c9-5ed225f20421/air-jordan-1-low-shoes-lFCSjp.png')
INSERT [dbo].[ProductVariant] ([id], [productID], [size], [color], [quantity], [soldQuantity], [image1], [image2], [image3], [image4]) VALUES (2, N'SP0001', 38, N'red', 26, 4, N'https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,q_auto:eco,u_126ab356-44d8-4a06-89b4-fcdcc8df0245,c_scale,fl_relative,w_1.0,h_1.0,fl_layer_apply/1c0c434c-9802-4556-89c7-a8600b2828d8/air-jordan-1-low-shoes-lFCSjp.png', N'https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,q_auto:eco,u_126ab356-44d8-4a06-89b4-fcdcc8df0245,c_scale,fl_relative,w_1.0,h_1.0,fl_layer_apply/7ce75f02-661e-4726-a940-bdcaff08caab/air-jordan-1-low-shoes-lFCSjp.png', N'https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,q_auto:eco,u_126ab356-44d8-4a06-89b4-fcdcc8df0245,c_scale,fl_relative,w_1.0,h_1.0,fl_layer_apply/a21d548e-eb3d-4a1b-a086-fffc780f0e0a/air-jordan-1-low-shoes-lFCSjp.png', N'https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,q_auto:eco,u_126ab356-44d8-4a06-89b4-fcdcc8df0245,c_scale,fl_relative,w_1.0,h_1.0,fl_layer_apply/da34aa91-c3b3-4b50-95c9-5ed225f20421/air-jordan-1-low-shoes-lFCSjp.png')
INSERT [dbo].[ProductVariant] ([id], [productID], [size], [color], [quantity], [soldQuantity], [image1], [image2], [image3], [image4]) VALUES (3, N'SP0002', 37, N'white', 60, 0, N'https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,q_auto:eco/7393b8e2-4350-45c1-bc82-2c83f7cd3777/air-force-1-07-easyon-shoes-LKXPhZ.png', N'https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,q_auto:eco/b55aa68b-8790-4023-8858-dbfb02e50dfd/air-force-1-07-easyon-shoes-LKXPhZ.png', N'https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,q_auto:eco/5ecaac47-c36b-4fe6-81d0-6efc7a062d34/air-force-1-07-easyon-shoes-LKXPhZ.png', N'https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,q_auto:eco/7a8a02d9-c52b-4f0f-9813-fa434c533958/air-force-1-07-easyon-shoes-LKXPhZ.png')
INSERT [dbo].[ProductVariant] ([id], [productID], [size], [color], [quantity], [soldQuantity], [image1], [image2], [image3], [image4]) VALUES (4, N'SP0002', 38, N'white', 60, 0, N'https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,q_auto:eco/7393b8e2-4350-45c1-bc82-2c83f7cd3777/air-force-1-07-easyon-shoes-LKXPhZ.png', N'https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,q_auto:eco/b55aa68b-8790-4023-8858-dbfb02e50dfd/air-force-1-07-easyon-shoes-LKXPhZ.png', N'https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,q_auto:eco/5ecaac47-c36b-4fe6-81d0-6efc7a062d34/air-force-1-07-easyon-shoes-LKXPhZ.png', N'https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,q_auto:eco/7a8a02d9-c52b-4f0f-9813-fa434c533958/air-force-1-07-easyon-shoes-LKXPhZ.png')
INSERT [dbo].[ProductVariant] ([id], [productID], [size], [color], [quantity], [soldQuantity], [image1], [image2], [image3], [image4]) VALUES (5, N'SP0002', 39, N'white', 60, 0, N'https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,q_auto:eco/7393b8e2-4350-45c1-bc82-2c83f7cd3777/air-force-1-07-easyon-shoes-LKXPhZ.png', N'https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,q_auto:eco/b55aa68b-8790-4023-8858-dbfb02e50dfd/air-force-1-07-easyon-shoes-LKXPhZ.png', N'https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,q_auto:eco/5ecaac47-c36b-4fe6-81d0-6efc7a062d34/air-force-1-07-easyon-shoes-LKXPhZ.png', N'https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,q_auto:eco/7a8a02d9-c52b-4f0f-9813-fa434c533958/air-force-1-07-easyon-shoes-LKXPhZ.png')
INSERT [dbo].[ProductVariant] ([id], [productID], [size], [color], [quantity], [soldQuantity], [image1], [image2], [image3], [image4]) VALUES (6, N'SP0002', 40, N'black', 35, 0, N'https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,q_auto:eco/7f4f0b02-147f-44dd-bac5-4f7e34a4d838/air-force-1-07-easyon-shoes-LKXPhZ.png', N'https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,q_auto:eco/fc8d6ba1-fd6d-4a95-a332-df7624c72549/air-force-1-07-easyon-shoes-LKXPhZ.png', N'https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,q_auto:eco/e9703a0b-ac10-458e-908f-53405675ef49/air-force-1-07-easyon-shoes-LKXPhZ.png', N'https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,q_auto:eco/5005af3a-549c-465b-a07d-a582b328ee46/air-force-1-07-easyon-shoes-LKXPhZ.png')
INSERT [dbo].[ProductVariant] ([id], [productID], [size], [color], [quantity], [soldQuantity], [image1], [image2], [image3], [image4]) VALUES (7, N'SP0003', 37, N'white', 60, 0, N'https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,q_auto:eco/cf43fd2a-f2c3-4d7e-ae24-65bd6e0c41c1/court-vision-low-shoes-ZwjLXN.png', N'https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,q_auto:eco/c3454421-279a-44c2-92f3-3aaebeed9616/court-vision-low-shoes-ZwjLXN.png', N'https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,q_auto:eco/db835823-8665-4d65-809c-aa105a22e392/court-vision-low-shoes-ZwjLXN.png', N'https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,q_auto:eco/25f753cd-6423-4194-850a-8cf65aeaed98/court-vision-low-shoes-ZwjLXN.png')
INSERT [dbo].[ProductVariant] ([id], [productID], [size], [color], [quantity], [soldQuantity], [image1], [image2], [image3], [image4]) VALUES (8, N'SP0004', 37, N'white', 60, 0, N'https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,q_auto:eco/057482ba-4077-40a4-aa18-ef8f1b8f4fcf/blazer-mid-77-vintage-shoes-dNWPTj.png', N'https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,q_auto:eco/431c0ec9-e2b5-49f8-97de-e7e03293bcab/blazer-mid-77-vintage-shoes-dNWPTj.png', N'https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,q_auto:eco/19380fda-5200-4122-a379-0d93c0764c69/blazer-mid-77-vintage-shoes-dNWPTj.png', N'https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,q_auto:eco/232c0ae8-99c8-497f-9a1e-af9f0fc8ef3c/blazer-mid-77-vintage-shoes-dNWPTj.png')
INSERT [dbo].[ProductVariant] ([id], [productID], [size], [color], [quantity], [soldQuantity], [image1], [image2], [image3], [image4]) VALUES (9, N'SP0005', 37, N'white', 57, 3, N'https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,q_auto:eco,u_126ab356-44d8-4a06-89b4-fcdcc8df0245,c_scale,fl_relative,w_1.0,h_1.0,fl_layer_apply/69945194-72f0-4d2a-aa2c-db8dc5da2379/jordan-stadium-90-shoes-Jn6ZH4.png', N'https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,q_auto:eco,u_126ab356-44d8-4a06-89b4-fcdcc8df0245,c_scale,fl_relative,w_1.0,h_1.0,fl_layer_apply/665fa7c8-3fa5-4762-be63-bb87ed3b85da/jordan-stadium-90-shoes-Jn6ZH4.png', N'https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,q_auto:eco,u_126ab356-44d8-4a06-89b4-fcdcc8df0245,c_scale,fl_relative,w_1.0,h_1.0,fl_layer_apply/ec7189e9-100b-4d8f-a32a-c47a9d214bc1/jordan-stadium-90-shoes-Jn6ZH4.png', N'https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,q_auto:eco,u_126ab356-44d8-4a06-89b4-fcdcc8df0245,c_scale,fl_relative,w_1.0,h_1.0,fl_layer_apply/db0bd8f7-e735-4b3b-9246-07e33d265ef7/jordan-stadium-90-shoes-Jn6ZH4.png')
INSERT [dbo].[ProductVariant] ([id], [productID], [size], [color], [quantity], [soldQuantity], [image1], [image2], [image3], [image4]) VALUES (10, N'SP0006', 37, N'white', 55, 5, N'https://assets.adidas.com/images/h_840,f_auto,q_auto,fl_lossy,c_fill,g_auto/3bbecbdf584e40398446a8bf0117cf62_9366/Samba_OG_Shoes_White_B75806_01_standard.jpg', N'https://assets.adidas.com/images/h_840,f_auto,q_auto,fl_lossy,c_fill,g_auto/97cd0902ae2e402b895aa8bf0117f98f_9366/Samba_OG_Shoes_White_B75806_03_standard.jpg', N'https://assets.adidas.com/images/h_840,f_auto,q_auto,fl_lossy,c_fill,g_auto/ec595635a2994adea094a8bf0117ef1a_9366/Samba_OG_Shoes_White_B75806_02_standard.jpg', N'https://assets.adidas.com/images/h_840,f_auto,q_auto,fl_lossy,c_fill,g_auto/671c62b81c3448e980aca8bf01181a93_9366/Samba_OG_Shoes_White_B75806_41_detail.jpg')
INSERT [dbo].[ProductVariant] ([id], [productID], [size], [color], [quantity], [soldQuantity], [image1], [image2], [image3], [image4]) VALUES (11, N'SP0007', 37, N'white', 59, 1, N'https://assets.adidas.com/images/h_840,f_auto,q_auto,fl_lossy,c_fill,g_auto/4875ee034a57417da114af623cfd5ff9_9366/Forum_Low_CL_Shoes_White_IH7907_01_standard.jpg', N'https://assets.adidas.com/images/h_840,f_auto,q_auto,fl_lossy,c_fill,g_auto/31a57c74315746738e86ed88a72a0a19_9366/Forum_Low_CL_Shoes_White_IH7907_03_standard.jpg', N'https://assets.adidas.com/images/h_840,f_auto,q_auto,fl_lossy,c_fill,g_auto/6f6ef5ea866a4c3fbbf36020d92a9184_9366/Forum_Low_CL_Shoes_White_IH7907_02_standard_hover.jpg', N'https://assets.adidas.com/images/h_840,f_auto,q_auto,fl_lossy,c_fill,g_auto/a5c56e842aae47339f30b97dbf994937_9366/Forum_Low_CL_Shoes_White_IH7907_04_standard.jpg')
INSERT [dbo].[ProductVariant] ([id], [productID], [size], [color], [quantity], [soldQuantity], [image1], [image2], [image3], [image4]) VALUES (12, N'SP0008', 37, N'brown', 58, 2, N'https://assets.adidas.com/images/h_840,f_auto,q_auto,fl_lossy,c_fill,g_auto/ce738cbe5342421996feaf5001044964_9366/Campus_00s_Shoes_Grey_HQ8707_01_standard.jpg', N'https://assets.adidas.com/images/h_840,f_auto,q_auto,fl_lossy,c_fill,g_auto/91f02f6240904feab069af500104656b_9366/Campus_00s_Shoes_Grey_HQ8707_02_standard_hover.jpg', N'https://assets.adidas.com/images/h_840,f_auto,q_auto,fl_lossy,c_fill,g_auto/f13fea67749e4f0a935aaf5001046ea7_9366/Campus_00s_Shoes_Grey_HQ8707_03_standard.jpg', N'https://assets.adidas.com/images/h_840,f_auto,q_auto,fl_lossy,c_fill,g_auto/229d8cd3679f45f48e35af500104788e_9366/Campus_00s_Shoes_Grey_HQ8707_04_standard.jpg')
INSERT [dbo].[ProductVariant] ([id], [productID], [size], [color], [quantity], [soldQuantity], [image1], [image2], [image3], [image4]) VALUES (13, N'SP0009', 37, N'black', 60, 0, N'https://assets.adidas.com/images/h_840,f_auto,q_auto,fl_lossy,c_fill,g_auto/1fa18f47b66e4f4980ba74d48de04ecc_9366/Handball_Spezial_Shoes_Blue_IF7087_01_standard.jpg', N'https://assets.adidas.com/images/h_840,f_auto,q_auto,fl_lossy,c_fill,g_auto/ccb2bd1de5914749aca1d329ea3172fb_9366/Handball_Spezial_Shoes_Blue_IF7087_03_standard.jpg', N'https://assets.adidas.com/images/h_840,f_auto,q_auto,fl_lossy,c_fill,g_auto/b28cb50d6e1246108ef0520cf17550bd_9366/Handball_Spezial_Shoes_Blue_IF7087_05_standard.jpg', N'https://assets.adidas.com/images/h_840,f_auto,q_auto,fl_lossy,c_fill,g_auto/bc508900850d4b768ae84509825e4a37_9366/Handball_Spezial_Shoes_Blue_IF7087_15_hover_standard.jpg')
INSERT [dbo].[ProductVariant] ([id], [productID], [size], [color], [quantity], [soldQuantity], [image1], [image2], [image3], [image4]) VALUES (14, N'SP0010', 37, N'white', 60, 0, N'https://assets.adidas.com/images/h_840,f_auto,q_auto,fl_lossy,c_fill,g_auto/c5e70fd8b9c94502b05b0ffd1d4cf4ac_9366/Stan_Smith_Decon_Shoes_White_IE9118_01_standard.jpg', N'https://assets.adidas.com/images/h_840,f_auto,q_auto,fl_lossy,c_fill,g_auto/be1e64d14c79406181aa8f79218dc591_9366/Stan_Smith_Decon_Shoes_White_IE9118_02_standard_hover.jpg', N'https://assets.adidas.com/images/h_840,f_auto,q_auto,fl_lossy,c_fill,g_auto/04fd8b73364043b2b83bc28e4d630b23_9366/Stan_Smith_Decon_Shoes_White_IE9118_03_standard.jpg', N'https://assets.adidas.com/images/h_840,f_auto,q_auto,fl_lossy,c_fill,g_auto/add766b5110f4fa69ca16da09b656277_9366/Stan_Smith_Decon_Shoes_White_IE9118_04_standard.jpg')
INSERT [dbo].[ProductVariant] ([id], [productID], [size], [color], [quantity], [soldQuantity], [image1], [image2], [image3], [image4]) VALUES (15, N'SP0011', 37, N'red', 47, 3, N'https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,q_auto:eco,u_126ab356-44d8-4a06-89b4-fcdcc8df0245,c_scale,fl_relative,w_1.0,h_1.0,fl_layer_apply/c2a2424b-4d35-490d-9d67-55c2c929e405/jordan-jumpman-slides-2C5ffD.png', N'https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,q_auto:eco,u_126ab356-44d8-4a06-89b4-fcdcc8df0245,c_scale,fl_relative,w_1.0,h_1.0,fl_layer_apply/2ba8dce4-9ffd-4951-b7fb-040afd260df1/jordan-jumpman-slides-2C5ffD.png', N'https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,q_auto:eco,u_126ab356-44d8-4a06-89b4-fcdcc8df0245,c_scale,fl_relative,w_1.0,h_1.0,fl_layer_apply/cd4d6ac3-cd57-475f-9a5f-ffc96a130bc8/jordan-jumpman-slides-2C5ffD.png', N'https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,q_auto:eco,u_126ab356-44d8-4a06-89b4-fcdcc8df0245,c_scale,fl_relative,w_1.0,h_1.0,fl_layer_apply/5b1bbe5b-9c48-4db3-9ad6-7bdb598f6e69/jordan-jumpman-slides-2C5ffD.png')
INSERT [dbo].[ProductVariant] ([id], [productID], [size], [color], [quantity], [soldQuantity], [image1], [image2], [image3], [image4]) VALUES (16, N'SP0011', 38, N'white', 26, 4, N'https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,q_auto:eco,u_126ab356-44d8-4a06-89b4-fcdcc8df0245,c_scale,fl_relative,w_1.0,h_1.0,fl_layer_apply/219bb5a5-4bb6-49c8-97cf-32c0e818b9e1/jordan-jumpman-slides-2C5ffD.png', N'https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,q_auto:eco,u_126ab356-44d8-4a06-89b4-fcdcc8df0245,c_scale,fl_relative,w_1.0,h_1.0,fl_layer_apply/99c87394-7d21-46ae-8782-e36aa5b5a91a/jordan-jumpman-slides-2C5ffD.png', N'https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,q_auto:eco,u_126ab356-44d8-4a06-89b4-fcdcc8df0245,c_scale,fl_relative,w_1.0,h_1.0,fl_layer_apply/4023ddc6-c570-4c69-82fd-00e5c92d7e98/jordan-jumpman-slides-2C5ffD.png', N'https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,q_auto:eco,u_126ab356-44d8-4a06-89b4-fcdcc8df0245,c_scale,fl_relative,w_1.0,h_1.0,fl_layer_apply/5d9bc3d8-0285-4548-8cbb-ab439e120568/jordan-jumpman-slides-2C5ffD.png')
INSERT [dbo].[ProductVariant] ([id], [productID], [size], [color], [quantity], [soldQuantity], [image1], [image2], [image3], [image4]) VALUES (17, N'SP0012', 37, N'pink', 54, 6, N'https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,q_auto:eco,u_126ab356-44d8-4a06-89b4-fcdcc8df0245,c_scale,fl_relative,w_1.0,h_1.0,fl_layer_apply/eb565318-308f-40bc-b9da-1db2cf863cc3/air-jordan-1-low-se-shoes-thpSD9.png', N'https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,q_auto:eco,u_126ab356-44d8-4a06-89b4-fcdcc8df0245,c_scale,fl_relative,w_1.0,h_1.0,fl_layer_apply/52943d9e-2af1-4845-af77-730abc2988c5/air-jordan-1-low-se-shoes-thpSD9.png', N'https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,q_auto:eco,u_126ab356-44d8-4a06-89b4-fcdcc8df0245,c_scale,fl_relative,w_1.0,h_1.0,fl_layer_apply/d8c9c54c-ef6b-4d68-a1e7-8cd6088e1eb5/air-jordan-1-low-se-shoes-thpSD9.png', N'https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,q_auto:eco,u_126ab356-44d8-4a06-89b4-fcdcc8df0245,c_scale,fl_relative,w_1.0,h_1.0,fl_layer_apply/00641512-5855-4b64-8c02-721ebc3ca085/air-jordan-1-low-se-shoes-thpSD9.png')
INSERT [dbo].[ProductVariant] ([id], [productID], [size], [color], [quantity], [soldQuantity], [image1], [image2], [image3], [image4]) VALUES (18, N'SP0012', 38, N'pink', 48, 7, N'https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,q_auto:eco,u_126ab356-44d8-4a06-89b4-fcdcc8df0245,c_scale,fl_relative,w_1.0,h_1.0,fl_layer_apply/eb565318-308f-40bc-b9da-1db2cf863cc3/air-jordan-1-low-se-shoes-thpSD9.png', N'https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,q_auto:eco,u_126ab356-44d8-4a06-89b4-fcdcc8df0245,c_scale,fl_relative,w_1.0,h_1.0,fl_layer_apply/52943d9e-2af1-4845-af77-730abc2988c5/air-jordan-1-low-se-shoes-thpSD9.png', N'https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,q_auto:eco,u_126ab356-44d8-4a06-89b4-fcdcc8df0245,c_scale,fl_relative,w_1.0,h_1.0,fl_layer_apply/d8c9c54c-ef6b-4d68-a1e7-8cd6088e1eb5/air-jordan-1-low-se-shoes-thpSD9.png', N'https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,q_auto:eco,u_126ab356-44d8-4a06-89b4-fcdcc8df0245,c_scale,fl_relative,w_1.0,h_1.0,fl_layer_apply/00641512-5855-4b64-8c02-721ebc3ca085/air-jordan-1-low-se-shoes-thpSD9.png')
INSERT [dbo].[ProductVariant] ([id], [productID], [size], [color], [quantity], [soldQuantity], [image1], [image2], [image3], [image4]) VALUES (19, N'SP0012', 39, N'pink', 58, 2, N'https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,q_auto:eco,u_126ab356-44d8-4a06-89b4-fcdcc8df0245,c_scale,fl_relative,w_1.0,h_1.0,fl_layer_apply/eb565318-308f-40bc-b9da-1db2cf863cc3/air-jordan-1-low-se-shoes-thpSD9.png', N'https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,q_auto:eco,u_126ab356-44d8-4a06-89b4-fcdcc8df0245,c_scale,fl_relative,w_1.0,h_1.0,fl_layer_apply/52943d9e-2af1-4845-af77-730abc2988c5/air-jordan-1-low-se-shoes-thpSD9.png', N'https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,q_auto:eco,u_126ab356-44d8-4a06-89b4-fcdcc8df0245,c_scale,fl_relative,w_1.0,h_1.0,fl_layer_apply/d8c9c54c-ef6b-4d68-a1e7-8cd6088e1eb5/air-jordan-1-low-se-shoes-thpSD9.png', N'https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,q_auto:eco,u_126ab356-44d8-4a06-89b4-fcdcc8df0245,c_scale,fl_relative,w_1.0,h_1.0,fl_layer_apply/00641512-5855-4b64-8c02-721ebc3ca085/air-jordan-1-low-se-shoes-thpSD9.png')
INSERT [dbo].[ProductVariant] ([id], [productID], [size], [color], [quantity], [soldQuantity], [image1], [image2], [image3], [image4]) VALUES (20, N'SP0013', 39, N'pink', 60, 0, N'https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,q_auto:eco/13945817-d8fd-4ccf-9084-740b0fd657f4/mercurial-vapor-15-academy-mg-low-top-football-boot-DBh36g.png', N'https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,q_auto:eco/ed4625fa-516e-437b-84f1-5507c66aad8f/mercurial-vapor-15-academy-mg-low-top-football-boot-DBh36g.png', N'https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,q_auto:eco/d584d878-b893-4530-a88a-884f69184fa1/mercurial-vapor-15-academy-mg-low-top-football-boot-DBh36g.png', N'https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,q_auto:eco/8ccef370-9662-49bd-8124-85b887f09aa8/mercurial-vapor-15-academy-mg-low-top-football-boot-DBh36g.png')
INSERT [dbo].[ProductVariant] ([id], [productID], [size], [color], [quantity], [soldQuantity], [image1], [image2], [image3], [image4]) VALUES (21, N'SP0013', 39, N'white', 98, 2, N'https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,q_auto:eco/af8c9cab-3408-410a-8862-d901f97d3266/mercurial-vapor-15-academy-multi-ground-low-top-football-boot-DBh36g.png', N'https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,q_auto:eco/105e5213-b232-4626-b4ed-2b58bf107e78/mercurial-vapor-15-academy-multi-ground-low-top-football-boot-DBh36g.png', N'https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,q_auto:eco/d1d97dc6-4db5-446f-80b1-d0e2f6928348/mercurial-vapor-15-academy-multi-ground-low-top-football-boot-DBh36g.png', N'https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,q_auto:eco/627a947a-851f-44bb-85f7-feb69b5e31c9/mercurial-vapor-15-academy-multi-ground-low-top-football-boot-DBh36g.png')
INSERT [dbo].[ProductVariant] ([id], [productID], [size], [color], [quantity], [soldQuantity], [image1], [image2], [image3], [image4]) VALUES (22, N'SP0013', 42, N'black', 40, 0, N'https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,q_auto:eco/f17a8048-64ac-448a-b6e6-229824321d74/mercurial-vapor-15-academy-multi-ground-low-top-football-boot-DBh36g.png', N'https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,q_auto:eco/6d344625-5067-4f4f-977c-8d6bceb0bd08/mercurial-vapor-15-academy-multi-ground-low-top-football-boot-DBh36g.png', N'https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,q_auto:eco/16e14918-3a8f-49c0-bfbd-944570d91c0c/mercurial-vapor-15-academy-multi-ground-low-top-football-boot-DBh36g.png', N'https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,q_auto:eco/4e54ecba-6b38-4745-b68c-1dc5c5b86298/mercurial-vapor-15-academy-multi-ground-low-top-football-boot-DBh36g.png')
INSERT [dbo].[ProductVariant] ([id], [productID], [size], [color], [quantity], [soldQuantity], [image1], [image2], [image3], [image4]) VALUES (23, N'SP0014', 38, N'black', 19, 1, N'https://assets.adidas.com/images/h_840,f_auto,q_auto,fl_lossy,c_fill,g_auto/23f55dafcfbf45e1a1ba5191c4886175_9366/TERREX_Hydroterra_Sandals_Black_IF7596_01_standard.jpg', N'https://assets.adidas.com/images/h_840,f_auto,q_auto,fl_lossy,c_fill,g_auto/fccdfd10bbe54ef6807442a4f590bbfa_9366/TERREX_Hydroterra_Sandals_Black_IF7596_02_standard.jpg', N'https://assets.adidas.com/images/h_840,f_auto,q_auto,fl_lossy,c_fill,g_auto/fa51462e764a4eee853bb64f1e7f6233_9366/TERREX_Hydroterra_Sandals_Black_IF7596_03_standard.jpg', N'https://assets.adidas.com/images/h_840,f_auto,q_auto,fl_lossy,c_fill,g_auto/06ee1c787754482cabd97032ce8c3725_9366/TERREX_Hydroterra_Sandals_Black_IF7596_04_standard.jpg')
INSERT [dbo].[ProductVariant] ([id], [productID], [size], [color], [quantity], [soldQuantity], [image1], [image2], [image3], [image4]) VALUES (24, N'SP0015', 38, N'black', 20, 0, N'https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_600,h_600/global/399870/03/sv01/fnd/PNA/fmt/png/FENTY-x-PUMA-Creeper-Phatty-In-Session-Men''s-Sneakers', N'https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_600,h_600/global/399870/03/fnd/PNA/fmt/png/FENTY-x-PUMA-Creeper-Phatty-In-Session-Men''s-Sneakers', N'https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_600,h_600/global/399870/03/sv02/fnd/PNA/fmt/png/FENTY-x-PUMA-Creeper-Phatty-In-Session-Men''s-Sneakers', N'https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_600,h_600/global/399870/03/sv04/fnd/PNA/fmt/png/FENTY-x-PUMA-Creeper-Phatty-In-Session-Men''s-Sneakers')
INSERT [dbo].[ProductVariant] ([id], [productID], [size], [color], [quantity], [soldQuantity], [image1], [image2], [image3], [image4]) VALUES (25, N'SP0015', 39, N'black', 18, 2, N'https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_600,h_600/global/399870/03/sv01/fnd/PNA/fmt/png/FENTY-x-PUMA-Creeper-Phatty-In-Session-Men''s-Sneakers', N'https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_600,h_600/global/399870/03/fnd/PNA/fmt/png/FENTY-x-PUMA-Creeper-Phatty-In-Session-Men''s-Sneakers', N'https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_600,h_600/global/399870/03/sv02/fnd/PNA/fmt/png/FENTY-x-PUMA-Creeper-Phatty-In-Session-Men''s-Sneakers', N'https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_600,h_600/global/399870/03/sv04/fnd/PNA/fmt/png/FENTY-x-PUMA-Creeper-Phatty-In-Session-Men''s-Sneakers')
INSERT [dbo].[ProductVariant] ([id], [productID], [size], [color], [quantity], [soldQuantity], [image1], [image2], [image3], [image4]) VALUES (26, N'SP0015', 42, N'black', 20, 0, N'https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_600,h_600/global/399870/03/sv01/fnd/PNA/fmt/png/FENTY-x-PUMA-Creeper-Phatty-In-Session-Men''s-Sneakers', N'https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_600,h_600/global/399870/03/fnd/PNA/fmt/png/FENTY-x-PUMA-Creeper-Phatty-In-Session-Men''s-Sneakers', N'https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_600,h_600/global/399870/03/sv02/fnd/PNA/fmt/png/FENTY-x-PUMA-Creeper-Phatty-In-Session-Men''s-Sneakers', N'https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_600,h_600/global/399870/03/sv04/fnd/PNA/fmt/png/FENTY-x-PUMA-Creeper-Phatty-In-Session-Men''s-Sneakers')
INSERT [dbo].[ProductVariant] ([id], [productID], [size], [color], [quantity], [soldQuantity], [image1], [image2], [image3], [image4]) VALUES (27, N'SP0015', 37, N'red', 37, 3, N'https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_2000,h_2000/global/399870/04/sv01/fnd/PNA/fmt/png/FENTY-x-PUMA-Creeper-Phatty-In-Session-Men''s-Sneakers', N'https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_2000,h_2000/global/399870/04/fnd/PNA/fmt/png/FENTY-x-PUMA-Creeper-Phatty-In-Session-Men''s-Sneakers', N'https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_2000,h_2000/global/399870/04/bv/fnd/PNA/fmt/png/FENTY-x-PUMA-Creeper-Phatty-In-Session-Men''s-Sneakers', N'https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_2000,h_2000/global/399870/04/sv02/fnd/PNA/fmt/png/FENTY-x-PUMA-Creeper-Phatty-In-Session-Men''s-Sneakers')
INSERT [dbo].[ProductVariant] ([id], [productID], [size], [color], [quantity], [soldQuantity], [image1], [image2], [image3], [image4]) VALUES (28, N'SP0015', 38, N'red', 38, 2, N'https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_2000,h_2000/global/399870/04/sv01/fnd/PNA/fmt/png/FENTY-x-PUMA-Creeper-Phatty-In-Session-Men''s-Sneakers', N'https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_2000,h_2000/global/399870/04/fnd/PNA/fmt/png/FENTY-x-PUMA-Creeper-Phatty-In-Session-Men''s-Sneakers', N'https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_2000,h_2000/global/399870/04/bv/fnd/PNA/fmt/png/FENTY-x-PUMA-Creeper-Phatty-In-Session-Men''s-Sneakers', N'https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_2000,h_2000/global/399870/04/sv02/fnd/PNA/fmt/png/FENTY-x-PUMA-Creeper-Phatty-In-Session-Men''s-Sneakers')
INSERT [dbo].[ProductVariant] ([id], [productID], [size], [color], [quantity], [soldQuantity], [image1], [image2], [image3], [image4]) VALUES (29, N'SP0015', 39, N'red', 40, 0, N'https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_2000,h_2000/global/399870/04/sv01/fnd/PNA/fmt/png/FENTY-x-PUMA-Creeper-Phatty-In-Session-Men''s-Sneakers', N'https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_2000,h_2000/global/399870/04/fnd/PNA/fmt/png/FENTY-x-PUMA-Creeper-Phatty-In-Session-Men''s-Sneakers', N'https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_2000,h_2000/global/399870/04/bv/fnd/PNA/fmt/png/FENTY-x-PUMA-Creeper-Phatty-In-Session-Men''s-Sneakers', N'https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_2000,h_2000/global/399870/04/sv02/fnd/PNA/fmt/png/FENTY-x-PUMA-Creeper-Phatty-In-Session-Men''s-Sneakers')
INSERT [dbo].[ProductVariant] ([id], [productID], [size], [color], [quantity], [soldQuantity], [image1], [image2], [image3], [image4]) VALUES (30, N'SP0015', 40, N'red', 40, 0, N'https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_2000,h_2000/global/399870/04/sv01/fnd/PNA/fmt/png/FENTY-x-PUMA-Creeper-Phatty-In-Session-Men''s-Sneakers', N'https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_2000,h_2000/global/399870/04/fnd/PNA/fmt/png/FENTY-x-PUMA-Creeper-Phatty-In-Session-Men''s-Sneakers', N'https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_2000,h_2000/global/399870/04/bv/fnd/PNA/fmt/png/FENTY-x-PUMA-Creeper-Phatty-In-Session-Men''s-Sneakers', N'https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_2000,h_2000/global/399870/04/sv02/fnd/PNA/fmt/png/FENTY-x-PUMA-Creeper-Phatty-In-Session-Men''s-Sneakers')
INSERT [dbo].[ProductVariant] ([id], [productID], [size], [color], [quantity], [soldQuantity], [image1], [image2], [image3], [image4]) VALUES (31, N'SP0016', 38, N'blue', 38, 2, N'https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_600,h_600/global/396841/01/sv01/fnd/PNA/fmt/png/Palermo-Vintage-Sneakers', N'https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_600,h_600/global/396841/01/mod03/fnd/PNA/fmt/png/Palermo-Vintage-Sneakers', N'https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_600,h_600/global/396841/01/fnd/PNA/fmt/png/Palermo-Vintage-Sneakers', N'https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_600,h_600/global/396841/01/sv02/fnd/PNA/fmt/png/Palermo-Vintage-Sneakers')
INSERT [dbo].[ProductVariant] ([id], [productID], [size], [color], [quantity], [soldQuantity], [image1], [image2], [image3], [image4]) VALUES (32, N'SP0016', 39, N'blue', 38, 2, N'https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_600,h_600/global/396841/01/sv01/fnd/PNA/fmt/png/Palermo-Vintage-Sneakers', N'https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_600,h_600/global/396841/01/mod03/fnd/PNA/fmt/png/Palermo-Vintage-Sneakers', N'https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_600,h_600/global/396841/01/fnd/PNA/fmt/png/Palermo-Vintage-Sneakers', N'https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_600,h_600/global/396841/01/sv02/fnd/PNA/fmt/png/Palermo-Vintage-Sneakers')
INSERT [dbo].[ProductVariant] ([id], [productID], [size], [color], [quantity], [soldQuantity], [image1], [image2], [image3], [image4]) VALUES (33, N'SP0016', 40, N'blue', 40, 0, N'https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_600,h_600/global/396841/01/sv01/fnd/PNA/fmt/png/Palermo-Vintage-Sneakers', N'https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_600,h_600/global/396841/01/mod03/fnd/PNA/fmt/png/Palermo-Vintage-Sneakers', N'https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_600,h_600/global/396841/01/fnd/PNA/fmt/png/Palermo-Vintage-Sneakers', N'https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_600,h_600/global/396841/01/sv02/fnd/PNA/fmt/png/Palermo-Vintage-Sneakers')
INSERT [dbo].[ProductVariant] ([id], [productID], [size], [color], [quantity], [soldQuantity], [image1], [image2], [image3], [image4]) VALUES (34, N'SP0016', 40, N'green', 20, 0, N'https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_600,h_600/global/396841/05/sv01/fnd/PNA/fmt/png/Palermo-Vintage-Sneakers', N'https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_600,h_600/global/396841/05/fnd/PNA/fmt/png/Palermo-Vintage-Sneakers', N'https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_600,h_600/global/396841/05/sv02/fnd/PNA/fmt/png/Palermo-Vintage-Sneakers', N'https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_600,h_600/global/396841/05/sv04/fnd/PNA/fmt/png/Palermo-Vintage-Sneakers')
INSERT [dbo].[ProductVariant] ([id], [productID], [size], [color], [quantity], [soldQuantity], [image1], [image2], [image3], [image4]) VALUES (35, N'SP0016', 41, N'green', 19, 1, N'https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_600,h_600/global/396841/05/sv01/fnd/PNA/fmt/png/Palermo-Vintage-Sneakers', N'https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_600,h_600/global/396841/05/fnd/PNA/fmt/png/Palermo-Vintage-Sneakers', N'https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_600,h_600/global/396841/05/sv02/fnd/PNA/fmt/png/Palermo-Vintage-Sneakers', N'https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_600,h_600/global/396841/05/sv04/fnd/PNA/fmt/png/Palermo-Vintage-Sneakers')
INSERT [dbo].[ProductVariant] ([id], [productID], [size], [color], [quantity], [soldQuantity], [image1], [image2], [image3], [image4]) VALUES (36, N'SP0017', 40, N'yellow', 29, 1, N'https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_600,h_600/global/395830/03/sv01/fnd/PNA/fmt/png/LOVE-MARATHON-Suede-Sneakers', N'https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_600,h_600/global/395830/03/mod01/fnd/PNA/fmt/png/LOVE-MARATHON-Suede-Sneakers', N'https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_600,h_600/global/395830/03/fnd/PNA/fmt/png/LOVE-MARATHON-Suede-Sneakers', N'https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_600,h_600/global/395830/03/sv02/fnd/PNA/fmt/png/LOVE-MARATHON-Suede-Sneakers')
INSERT [dbo].[ProductVariant] ([id], [productID], [size], [color], [quantity], [soldQuantity], [image1], [image2], [image3], [image4]) VALUES (37, N'SP0017', 41, N'yellow', 30, 0, N'https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_600,h_600/global/395830/03/sv01/fnd/PNA/fmt/png/LOVE-MARATHON-Suede-Sneakers', N'https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_600,h_600/global/395830/03/mod01/fnd/PNA/fmt/png/LOVE-MARATHON-Suede-Sneakers', N'https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_600,h_600/global/395830/03/fnd/PNA/fmt/png/LOVE-MARATHON-Suede-Sneakers', N'https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_600,h_600/global/395830/03/sv02/fnd/PNA/fmt/png/LOVE-MARATHON-Suede-Sneakers')
INSERT [dbo].[ProductVariant] ([id], [productID], [size], [color], [quantity], [soldQuantity], [image1], [image2], [image3], [image4]) VALUES (38, N'SP0017', 37, N'purple', 30, 0, N'https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_600,h_600/global/395830/01/sv01/fnd/PNA/fmt/png/LOVE-MARATHON-Suede-Sneakers', N'https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_600,h_600/global/395830/01/mod01/fnd/PNA/fmt/png/LOVE-MARATHON-Suede-Sneakers', N'https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_600,h_600/global/395830/01/fnd/PNA/fmt/png/LOVE-MARATHON-Suede-Sneakers', N'https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_600,h_600/global/395830/01/sv02/fnd/PNA/fmt/png/LOVE-MARATHON-Suede-Sneakers')
INSERT [dbo].[ProductVariant] ([id], [productID], [size], [color], [quantity], [soldQuantity], [image1], [image2], [image3], [image4]) VALUES (39, N'SP0017', 39, N'purple', 30, 0, N'https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_600,h_600/global/395830/01/sv01/fnd/PNA/fmt/png/LOVE-MARATHON-Suede-Sneakers', N'https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_600,h_600/global/395830/01/mod01/fnd/PNA/fmt/png/LOVE-MARATHON-Suede-Sneakers', N'https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_600,h_600/global/395830/01/fnd/PNA/fmt/png/LOVE-MARATHON-Suede-Sneakers', N'https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_600,h_600/global/395830/01/sv02/fnd/PNA/fmt/png/LOVE-MARATHON-Suede-Sneakers')
INSERT [dbo].[ProductVariant] ([id], [productID], [size], [color], [quantity], [soldQuantity], [image1], [image2], [image3], [image4]) VALUES (40, N'SP0017', 42, N'purple', 30, 0, N'https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_600,h_600/global/395830/01/sv01/fnd/PNA/fmt/png/LOVE-MARATHON-Suede-Sneakers', N'https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_600,h_600/global/395830/01/mod01/fnd/PNA/fmt/png/LOVE-MARATHON-Suede-Sneakers', N'https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_600,h_600/global/395830/01/fnd/PNA/fmt/png/LOVE-MARATHON-Suede-Sneakers', N'https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_600,h_600/global/395830/01/sv02/fnd/PNA/fmt/png/LOVE-MARATHON-Suede-Sneakers')
INSERT [dbo].[ProductVariant] ([id], [productID], [size], [color], [quantity], [soldQuantity], [image1], [image2], [image3], [image4]) VALUES (41, N'SP0017', 38, N'green', 30, 0, N'https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_600,h_600/global/395830/02/sv01/fnd/PNA/fmt/png/LOVE-MARATHON-Suede-Sneakers', N'https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_600,h_600/global/395830/02/mod01/fnd/PNA/fmt/png/LOVE-MARATHON-Suede-Sneakers', N'https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_600,h_600/global/395830/02/fnd/PNA/fmt/png/LOVE-MARATHON-Suede-Sneakers', N'https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_600,h_600/global/395830/02/sv02/fnd/PNA/fmt/png/LOVE-MARATHON-Suede-Sneakers')
INSERT [dbo].[ProductVariant] ([id], [productID], [size], [color], [quantity], [soldQuantity], [image1], [image2], [image3], [image4]) VALUES (42, N'SP0017', 39, N'green', 28, 2, N'https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_600,h_600/global/395830/02/sv01/fnd/PNA/fmt/png/LOVE-MARATHON-Suede-Sneakers', N'https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_600,h_600/global/395830/02/mod01/fnd/PNA/fmt/png/LOVE-MARATHON-Suede-Sneakers', N'https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_600,h_600/global/395830/02/fnd/PNA/fmt/png/LOVE-MARATHON-Suede-Sneakers', N'https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_600,h_600/global/395830/02/sv02/fnd/PNA/fmt/png/LOVE-MARATHON-Suede-Sneakers')
INSERT [dbo].[ProductVariant] ([id], [productID], [size], [color], [quantity], [soldQuantity], [image1], [image2], [image3], [image4]) VALUES (43, N'SP0018', 38, N'red', 29, 1, N'https://product.hstatic.net/200000536779/product/player-1-red2_0169e1c5d58445b1975c304f21180c03_master.png', N'https://product.hstatic.net/200000536779/product/player-1-red3_68f78b693c754c17b328c6232626e073_master.png', N'https://product.hstatic.net/200000536779/product/player-1-red4_862604fef2ab45c3adb59d746b068167_master.png', N'https://product.hstatic.net/200000536779/product/player-1-red5_515b671d2982470dbf10e69bc69c31cf_master.png')
INSERT [dbo].[ProductVariant] ([id], [productID], [size], [color], [quantity], [soldQuantity], [image1], [image2], [image3], [image4]) VALUES (44, N'SP0018', 39, N'red', 29, 1, N'https://product.hstatic.net/200000536779/product/player-1-red2_0169e1c5d58445b1975c304f21180c03_master.png', N'https://product.hstatic.net/200000536779/product/player-1-red3_68f78b693c754c17b328c6232626e073_master.png', N'https://product.hstatic.net/200000536779/product/player-1-red4_862604fef2ab45c3adb59d746b068167_master.png', N'https://product.hstatic.net/200000536779/product/player-1-red5_515b671d2982470dbf10e69bc69c31cf_master.png')
INSERT [dbo].[ProductVariant] ([id], [productID], [size], [color], [quantity], [soldQuantity], [image1], [image2], [image3], [image4]) VALUES (45, N'SP0018', 40, N'red', 28, 2, N'https://product.hstatic.net/200000536779/product/player-1-red2_0169e1c5d58445b1975c304f21180c03_master.png', N'https://product.hstatic.net/200000536779/product/player-1-red3_68f78b693c754c17b328c6232626e073_master.png', N'https://product.hstatic.net/200000536779/product/player-1-red4_862604fef2ab45c3adb59d746b068167_master.png', N'https://product.hstatic.net/200000536779/product/player-1-red5_515b671d2982470dbf10e69bc69c31cf_master.png')
INSERT [dbo].[ProductVariant] ([id], [productID], [size], [color], [quantity], [soldQuantity], [image1], [image2], [image3], [image4]) VALUES (46, N'SP0018', 43, N'red', 30, 0, N'https://product.hstatic.net/200000536779/product/player-1-red2_0169e1c5d58445b1975c304f21180c03_master.png', N'https://product.hstatic.net/200000536779/product/player-1-red3_68f78b693c754c17b328c6232626e073_master.png', N'https://product.hstatic.net/200000536779/product/player-1-red4_862604fef2ab45c3adb59d746b068167_master.png', N'https://product.hstatic.net/200000536779/product/player-1-red5_515b671d2982470dbf10e69bc69c31cf_master.png')
INSERT [dbo].[ProductVariant] ([id], [productID], [size], [color], [quantity], [soldQuantity], [image1], [image2], [image3], [image4]) VALUES (47, N'SP0019', 39, N'black', 0, 5, N'https://product.hstatic.net/200000536779/product/snap2_11ac3cd4190e4181bff185f85d15bde4_master.png', N'https://product.hstatic.net/200000536779/product/snap-bg-2_4d949e15d45442e9830a5dbad8eb6970_master.png', N'https://product.hstatic.net/200000536779/product/snap-bg-3_76ed2f5a827a4bf68d01759fd2545268_master.png', N'https://product.hstatic.net/200000536779/product/snap-bg-4_c2849c5f9d0647b8aad4f4dd4ed2de93_master.png')
INSERT [dbo].[ProductVariant] ([id], [productID], [size], [color], [quantity], [soldQuantity], [image1], [image2], [image3], [image4]) VALUES (48, N'SP0019', 40, N'black', 28, 2, N'https://product.hstatic.net/200000536779/product/snap2_11ac3cd4190e4181bff185f85d15bde4_master.png', N'https://product.hstatic.net/200000536779/product/snap-bg-2_4d949e15d45442e9830a5dbad8eb6970_master.png', N'https://product.hstatic.net/200000536779/product/snap-bg-3_76ed2f5a827a4bf68d01759fd2545268_master.png', N'https://product.hstatic.net/200000536779/product/snap-bg-4_c2849c5f9d0647b8aad4f4dd4ed2de93_master.png')
INSERT [dbo].[ProductVariant] ([id], [productID], [size], [color], [quantity], [soldQuantity], [image1], [image2], [image3], [image4]) VALUES (49, N'SP0019', 42, N'black', 30, 0, N'https://product.hstatic.net/200000536779/product/snap2_11ac3cd4190e4181bff185f85d15bde4_master.png', N'https://product.hstatic.net/200000536779/product/snap-bg-2_4d949e15d45442e9830a5dbad8eb6970_master.png', N'https://product.hstatic.net/200000536779/product/snap-bg-3_76ed2f5a827a4bf68d01759fd2545268_master.png', N'https://product.hstatic.net/200000536779/product/snap-bg-4_c2849c5f9d0647b8aad4f4dd4ed2de93_master.png')
INSERT [dbo].[ProductVariant] ([id], [productID], [size], [color], [quantity], [soldQuantity], [image1], [image2], [image3], [image4]) VALUES (50, N'SP0020', 37, N'organe', 40, 0, N'https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_600,h_600/global/310474/01/sv01/fnd/PNA/fmt/png/Deviate-NITRO%E2%84%A2-3-FADE-Men''s-Running-Shoes', N'https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_600,h_600/global/310474/01/fnd/PNA/fmt/png/Deviate-NITRO%E2%84%A2-3-FADE-Men''s-Running-Shoes', N'https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_600,h_600/global/310474/01/bv/fnd/PNA/fmt/png/Deviate-NITRO%E2%84%A2-3-FADE-Men''s-Running-Shoes', N'https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_600,h_600/global/310474/01/sv02/fnd/PNA/fmt/png/Deviate-NITRO%E2%84%A2-3-FADE-Men''s-Running-Shoes')
INSERT [dbo].[ProductVariant] ([id], [productID], [size], [color], [quantity], [soldQuantity], [image1], [image2], [image3], [image4]) VALUES (51, N'SP0020', 38, N'organe', 40, 0, N'https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_600,h_600/global/310474/01/sv01/fnd/PNA/fmt/png/Deviate-NITRO%E2%84%A2-3-FADE-Men''s-Running-Shoes', N'https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_600,h_600/global/310474/01/fnd/PNA/fmt/png/Deviate-NITRO%E2%84%A2-3-FADE-Men''s-Running-Shoes', N'https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_600,h_600/global/310474/01/bv/fnd/PNA/fmt/png/Deviate-NITRO%E2%84%A2-3-FADE-Men''s-Running-Shoes', N'https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_600,h_600/global/310474/01/sv02/fnd/PNA/fmt/png/Deviate-NITRO%E2%84%A2-3-FADE-Men''s-Running-Shoes')
INSERT [dbo].[ProductVariant] ([id], [productID], [size], [color], [quantity], [soldQuantity], [image1], [image2], [image3], [image4]) VALUES (52, N'SP0020', 39, N'organe', 40, 0, N'https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_600,h_600/global/310474/01/sv01/fnd/PNA/fmt/png/Deviate-NITRO%E2%84%A2-3-FADE-Men''s-Running-Shoes', N'https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_600,h_600/global/310474/01/fnd/PNA/fmt/png/Deviate-NITRO%E2%84%A2-3-FADE-Men''s-Running-Shoes', N'https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_600,h_600/global/310474/01/bv/fnd/PNA/fmt/png/Deviate-NITRO%E2%84%A2-3-FADE-Men''s-Running-Shoes', N'https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_600,h_600/global/310474/01/sv02/fnd/PNA/fmt/png/Deviate-NITRO%E2%84%A2-3-FADE-Men''s-Running-Shoes')
SET IDENTITY_INSERT [dbo].[ProductVariant] OFF
SET IDENTITY_INSERT [dbo].[Supplier] ON 

INSERT [dbo].[Supplier] ([id], [name], [email], [phoneNumber], [address]) VALUES (1, N'Công ty giày dép AKA', N'aka@gmail.com', N'0312312363', N'TP Hồ Chí Minh')
INSERT [dbo].[Supplier] ([id], [name], [email], [phoneNumber], [address]) VALUES (2, N'Công ty THHH 1 thành viên', N'1tv@gmail.com', N'0345123456', N'113/3/4/5/6 Nguyễn A, P.17, Q.7, TP Hồ Chí Minh')
INSERT [dbo].[Supplier] ([id], [name], [email], [phoneNumber], [address]) VALUES (3, N'Công ty TNHH Giày Nam Việt', N'NamViet111@gmail.com', N'0945685234', N'Số D17/4A Đinh Đức Thiện, Ấp 4, X. Bình Chánh, H. Bình Chánh, TP. Hồ Chí Minh, Việt Nam')
INSERT [dbo].[Supplier] ([id], [name], [email], [phoneNumber], [address]) VALUES (4, N'Công Ty TNHH Sản Xuất Giày Dép Quốc Định', N'GDquocdinhhhh@gmail.com', N'0933167373', N'9/42 Thống Nhất, P. 15, Q. Gò Vấp, TP. Hồ Chí Minh, Việt Nam')
INSERT [dbo].[Supplier] ([id], [name], [email], [phoneNumber], [address]) VALUES (5, N'Công Ty TNHH Thuận Buồm', N'Thuanbuommm213@gmail.com', N'0904678902', N'Số 429/3, Khu Phố Thạnh Bình, Phường An Thạnh, Thành Phố Thuận An, Bình Dương, Việt Nam')
INSERT [dbo].[Supplier] ([id], [name], [email], [phoneNumber], [address]) VALUES (6, N'Công ty THNH Mai Việt', N'MaiViet@gmail.com', N'0367895874', N'12 Nguyễn Văn Bảo, Phường 4, Q. Gò Vấp, Hồ Chí Minh')
SET IDENTITY_INSERT [dbo].[Supplier] OFF
ALTER TABLE [dbo].[Cart]  WITH CHECK ADD FOREIGN KEY([accountID])
REFERENCES [dbo].[Account] ([uID])
GO
ALTER TABLE [dbo].[Cart]  WITH CHECK ADD FOREIGN KEY([productVariantID])
REFERENCES [dbo].[ProductVariant] ([id])
GO
ALTER TABLE [dbo].[Invoice]  WITH CHECK ADD FOREIGN KEY([accountID])
REFERENCES [dbo].[Account] ([uID])
GO
ALTER TABLE [dbo].[InvoiceDetail]  WITH CHECK ADD FOREIGN KEY([invoiceID])
REFERENCES [dbo].[Invoice] ([id])
GO
ALTER TABLE [dbo].[InvoiceDetail]  WITH CHECK ADD  CONSTRAINT [FK_InvoiceDetail_ProductVa] FOREIGN KEY([productVariantID])
REFERENCES [dbo].[ProductVariant] ([id])
GO
ALTER TABLE [dbo].[InvoiceDetail] CHECK CONSTRAINT [FK_InvoiceDetail_ProductVa]
GO
ALTER TABLE [dbo].[Product]  WITH CHECK ADD  CONSTRAINT [FK_Product_Brand] FOREIGN KEY([brandID])
REFERENCES [dbo].[Brand] ([bID])
GO
ALTER TABLE [dbo].[Product] CHECK CONSTRAINT [FK_Product_Brand]
GO
ALTER TABLE [dbo].[Product]  WITH CHECK ADD  CONSTRAINT [FK_Product_Category] FOREIGN KEY([categoryID])
REFERENCES [dbo].[Category] ([cID])
GO
ALTER TABLE [dbo].[Product] CHECK CONSTRAINT [FK_Product_Category]
GO
ALTER TABLE [dbo].[Product]  WITH CHECK ADD  CONSTRAINT [FK_Product_Supplier] FOREIGN KEY([supplierID])
REFERENCES [dbo].[Supplier] ([id])
GO
ALTER TABLE [dbo].[Product] CHECK CONSTRAINT [FK_Product_Supplier]
GO
ALTER TABLE [dbo].[ProductVariant]  WITH CHECK ADD FOREIGN KEY([productID])
REFERENCES [dbo].[Product] ([id])
GO
USE [master]
GO
ALTER DATABASE [QuanLyBanGiayDep] SET  READ_WRITE 
GO
