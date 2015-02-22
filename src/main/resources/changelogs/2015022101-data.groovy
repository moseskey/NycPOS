databaseChangeLog {
  def getTemplateFileContents = { file ->
    def f = new File('./src/main/resources/' + file)
    return "decode('${f.bytes.encodeBase64()}', 'base64')"
  }

  changeSet(id: 'insertdata-1', author: 'kenneth.shaw@knq.io') {
    insert(tableName: 'applications') {
      column(name: 'id', value: 'unicentaopos')
      column(name: 'name', value: 'uniCenta oPOS')
      column(name: 'version', value: '3.81')
    }
  }

  changeSet(id: 'insertdata-2', author: 'kenneth.shaw@knq.io') {
    insert(tableName: 'breaks') {
      column(name: 'id', value: '0')
      column(name: 'name', value: 'Lunch Break')
      column(name: 'notes')
      column(name: 'visible', valueBoolean: true)
    }
  }

  changeSet(id: 'insertdata-3', author: 'kenneth.shaw@knq.io') {
    insert(tableName: 'breaks') {
      column(name: 'id', value: '1')
      column(name: 'name', value: 'Tea Break')
      column(name: 'notes')
      column(name: 'visible', valueBoolean: true)
    }
  }

  changeSet(id: 'insertdata-4', author: 'kenneth.shaw@knq.io') {
    insert(tableName: 'breaks') {
      column(name: 'id', value: '2')
      column(name: 'name', value: 'Mid Break')
      column(name: 'notes')
      column(name: 'visible', valueBoolean: true)
    }
  }

  changeSet(id: 'insertdata-5', author: 'kenneth.shaw@knq.io') {
    insert(tableName: 'categories') {
      column(name: 'id', value: '000')
      column(name: 'name', value: 'Category Standard')
      column(name: 'parentid')
      column(name: 'image')
      column(name: 'texttip')
      column(name: 'catshowname', valueBoolean: true)
    }
  }

  changeSet(id: 'insertdata-6', author: 'kenneth.shaw@knq.io') {
    insert(tableName: 'categories') {
      column(name: 'id', value: 'xxx999')
      column(name: 'name', value: '***')
      column(name: 'parentid')
      column(name: 'image')
      column(name: 'texttip')
      column(name: 'catshowname', valueBoolean: true)
    }
  }

  changeSet(id: 'insertdata-7', author: 'kenneth.shaw@knq.io') {
    insert(tableName: 'closedcash') {
      column(name: 'money', value: 'f2f94e25-8b88-443e-8de7-c4a68395f59e')
      column(name: 'host', value: 'ken-desktop')
      column(name: 'hostsequence', valueNumeric: 2)
      column(name: 'datestart', valueDate: '2015-02-18T07:54:26.567')
      column(name: 'dateend')
      column(name: 'nosales', valueNumeric: 0)
    }
  }

  changeSet(id: 'insertdata-8', author: 'kenneth.shaw@knq.io') {
    insert(tableName: 'floors') {
      column(name: 'id', value: '0')
      column(name: 'name', value: 'Restaurant floor')
      column(name: 'image', valueComputed: getTemplateFileContents('templates/default/floors.png'))
    }
  }

  changeSet(id: 'insertdata-9', author: 'kenneth.shaw@knq.io') {
    insert(tableName: 'locations') {
      column(name: 'id', value: '0')
      column(name: 'name', value: 'General')
      column(name: 'address')
    }
  }

  changeSet(id: 'insertdata-14', author: 'kenneth.shaw@knq.io') {
    insert(tableName: 'places') {
      column(name: 'id', value: '1')
      column(name: 'name', value: 'Table 1')
      column(name: 'x', valueNumeric: 80)
      column(name: 'y', valueNumeric: 70)
      column(name: 'floor', value: '0')
      column(name: 'customer')
      column(name: 'waiter')
      column(name: 'ticketid')
      column(name: 'tablemoved', valueBoolean: false)
    }
  }

  changeSet(id: 'insertdata-15', author: 'kenneth.shaw@knq.io') {
    insert(tableName: 'places') {
      column(name: 'id', value: '2')
      column(name: 'name', value: 'Table 2')
      column(name: 'x', valueNumeric: 250)
      column(name: 'y', valueNumeric: 75)
      column(name: 'floor', value: '0')
      column(name: 'customer')
      column(name: 'waiter')
      column(name: 'ticketid')
      column(name: 'tablemoved', valueBoolean: false)
    }
  }

  changeSet(id: 'insertdata-16', author: 'kenneth.shaw@knq.io') {
    insert(tableName: 'places') {
      column(name: 'id', value: '3')
      column(name: 'name', value: 'Table 3')
      column(name: 'x', valueNumeric: 400)
      column(name: 'y', valueNumeric: 75)
      column(name: 'floor', value: '0')
      column(name: 'customer')
      column(name: 'waiter')
      column(name: 'ticketid')
      column(name: 'tablemoved', valueBoolean: false)
    }
  }

  changeSet(id: 'insertdata-17', author: 'kenneth.shaw@knq.io') {
    insert(tableName: 'places') {
      column(name: 'id', value: '4')
      column(name: 'name', value: 'Table 4')
      column(name: 'x', valueNumeric: 80)
      column(name: 'y', valueNumeric: 200)
      column(name: 'floor', value: '0')
      column(name: 'customer')
      column(name: 'waiter')
      column(name: 'ticketid')
      column(name: 'tablemoved', valueBoolean: false)
    }
  }

  changeSet(id: 'insertdata-18', author: 'kenneth.shaw@knq.io') {
    insert(tableName: 'places') {
      column(name: 'id', value: '5')
      column(name: 'name', value: 'Table 5')
      column(name: 'x', valueNumeric: 260)
      column(name: 'y', valueNumeric: 210)
      column(name: 'floor', value: '0')
      column(name: 'customer')
      column(name: 'waiter')
      column(name: 'ticketid')
      column(name: 'tablemoved', valueBoolean: false)
    }
  }

  changeSet(id: 'insertdata-19', author: 'kenneth.shaw@knq.io') {
    insert(tableName: 'places') {
      column(name: 'id', value: '6')
      column(name: 'name', value: 'Table 6')
      column(name: 'x', valueNumeric: 430)
      column(name: 'y', valueNumeric: 210)
      column(name: 'floor', value: '0')
      column(name: 'customer')
      column(name: 'waiter')
      column(name: 'ticketid')
      column(name: 'tablemoved', valueBoolean: false)
    }
  }

  changeSet(id: 'insertdata-20', author: 'kenneth.shaw@knq.io') {
    insert(tableName: 'places') {
      column(name: 'id', value: '7')
      column(name: 'name', value: 'Table 7')
      column(name: 'x', valueNumeric: 80)
      column(name: 'y', valueNumeric: 330)
      column(name: 'floor', value: '0')
      column(name: 'customer')
      column(name: 'waiter')
      column(name: 'ticketid')
      column(name: 'tablemoved', valueBoolean: false)
    }
  }

  changeSet(id: 'insertdata-21', author: 'kenneth.shaw@knq.io') {
    insert(tableName: 'places') {
      column(name: 'id', value: '8')
      column(name: 'name', value: 'Table 8')
      column(name: 'x', valueNumeric: 190)
      column(name: 'y', valueNumeric: 350)
      column(name: 'floor', value: '0')
      column(name: 'customer')
      column(name: 'waiter')
      column(name: 'ticketid')
      column(name: 'tablemoved', valueBoolean: false)
    }
  }

  changeSet(id: 'insertdata-22', author: 'kenneth.shaw@knq.io') {
    insert(tableName: 'places') {
      column(name: 'id', value: '9')
      column(name: 'name', value: 'Table 9')
      column(name: 'x', valueNumeric: 295)
      column(name: 'y', valueNumeric: 350)
      column(name: 'floor', value: '0')
      column(name: 'customer')
      column(name: 'waiter')
      column(name: 'ticketid')
      column(name: 'tablemoved', valueBoolean: false)
    }
  }

  changeSet(id: 'insertdata-23', author: 'kenneth.shaw@knq.io') {
    insert(tableName: 'places') {
      column(name: 'id', value: '10')
      column(name: 'name', value: 'Table 10')
      column(name: 'x', valueNumeric: 430)
      column(name: 'y', valueNumeric: 345)
      column(name: 'floor', value: '0')
      column(name: 'customer')
      column(name: 'waiter')
      column(name: 'ticketid')
      column(name: 'tablemoved', valueBoolean: false)
    }
  }

  changeSet(id: 'insertdata-24', author: 'kenneth.shaw@knq.io') {
    insert(tableName: 'places') {
      column(name: 'id', value: '11')
      column(name: 'name', value: 'Table 11')
      column(name: 'x', valueNumeric: 550)
      column(name: 'y', valueNumeric: 135)
      column(name: 'floor', value: '0')
      column(name: 'customer')
      column(name: 'waiter')
      column(name: 'ticketid')
      column(name: 'tablemoved', valueBoolean: false)
    }
  }

  changeSet(id: 'insertdata-25', author: 'kenneth.shaw@knq.io') {
    insert(tableName: 'places') {
      column(name: 'id', value: '12')
      column(name: 'name', value: 'Table 12')
      column(name: 'x', valueNumeric: 550)
      column(name: 'y', valueNumeric: 290)
      column(name: 'floor', value: '0')
      column(name: 'customer')
      column(name: 'waiter')
      column(name: 'ticketid')
      column(name: 'tablemoved', valueBoolean: false)
    }
  }

  changeSet(id: 'insertdata-28', author: 'kenneth.shaw@knq.io') {
    insert(tableName: 'resources') {
      column(name: 'id', value: '0')
      column(name: 'name', value: 'Menu.Root')
      column(name: 'restype', valueNumeric: 0)
      column(name: 'content', valueComputed: getTemplateFileContents('templates/default/Menu.Root.txt'))
    }
  }

  changeSet(id: 'insertdata-29', author: 'kenneth.shaw@knq.io') {
    insert(tableName: 'resources') {
      column(name: 'id', value: '1')
      column(name: 'name', value: 'coin.2')
      column(name: 'restype', valueNumeric: 1)
      column(name: 'content', valueComputed: getTemplateFileContents('templates/default/coin.2.png'))
    }
  }

  changeSet(id: 'insertdata-30', author: 'kenneth.shaw@knq.io') {
    insert(tableName: 'resources') {
      column(name: 'id', value: '2')
      column(name: 'name', value: 'coin.1')
      column(name: 'restype', valueNumeric: 1)
      column(name: 'content', valueComputed: getTemplateFileContents('templates/default/coin.1.png'))
    }
  }

  changeSet(id: 'insertdata-31', author: 'kenneth.shaw@knq.io') {
    insert(tableName: 'resources') {
      column(name: 'id', value: '3')
      column(name: 'name', value: 'coin.50')
      column(name: 'restype', valueNumeric: 1)
      column(name: 'content', valueComputed: getTemplateFileContents('templates/default/coin.50.png'))
    }
  }

  changeSet(id: 'insertdata-32', author: 'kenneth.shaw@knq.io') {
    insert(tableName: 'resources') {
      column(name: 'id', value: '4')
      column(name: 'name', value: 'coin.20')
      column(name: 'restype', valueNumeric: 1)
      column(name: 'content', valueComputed: getTemplateFileContents('templates/default/coin.20.png'))
    }
  }

  changeSet(id: 'insertdata-33', author: 'kenneth.shaw@knq.io') {
    insert(tableName: 'resources') {
      column(name: 'id', value: '5')
      column(name: 'name', value: 'coin.10')
      column(name: 'restype', valueNumeric: 1)
      column(name: 'content', valueComputed: getTemplateFileContents('templates/default/coin.10.png'))
    }
  }

  changeSet(id: 'insertdata-34', author: 'kenneth.shaw@knq.io') {
    insert(tableName: 'resources') {
      column(name: 'id', value: '6')
      column(name: 'name', value: 'coin.05')
      column(name: 'restype', valueNumeric: 1)
      column(name: 'content', valueComputed: getTemplateFileContents('templates/default/coin.05.png'))
    }
  }

  changeSet(id: 'insertdata-35', author: 'kenneth.shaw@knq.io') {
    insert(tableName: 'resources') {
      column(name: 'id', value: '7')
      column(name: 'name', value: 'coin.02')
      column(name: 'restype', valueNumeric: 1)
      column(name: 'content', valueComputed: getTemplateFileContents('templates/default/coin.02.png'))
    }
  }

  changeSet(id: 'insertdata-36', author: 'kenneth.shaw@knq.io') {
    insert(tableName: 'resources') {
      column(name: 'id', value: '8')
      column(name: 'name', value: 'coin.01')
      column(name: 'restype', valueNumeric: 1)
      column(name: 'content', valueComputed: getTemplateFileContents('templates/default/coin.01.png'))
    }
  }

  changeSet(id: 'insertdata-37', author: 'kenneth.shaw@knq.io') {
    insert(tableName: 'resources') {
      column(name: 'id', value: '9')
      column(name: 'name', value: 'img.cash')
      column(name: 'restype', valueNumeric: 1)
      column(name: 'content', valueComputed: getTemplateFileContents('templates/default/cash.png'))
    }
  }

  changeSet(id: 'insertdata-38', author: 'kenneth.shaw@knq.io') {
    insert(tableName: 'resources') {
      column(name: 'id', value: '10')
      column(name: 'name', value: 'img.cashdrawer')
      column(name: 'restype', valueNumeric: 1)
      column(name: 'content', valueComputed: getTemplateFileContents('templates/default/cashdrawer.png'))
    }
  }

  changeSet(id: 'insertdata-39', author: 'kenneth.shaw@knq.io') {
    insert(tableName: 'resources') {
      column(name: 'id', value: '11')
      column(name: 'name', value: 'img.discount')
      column(name: 'restype', valueNumeric: 1)
      column(name: 'content', valueComputed: getTemplateFileContents('templates/default/discount.png'))
    }
  }

  changeSet(id: 'insertdata-40', author: 'kenneth.shaw@knq.io') {
    insert(tableName: 'resources') {
      column(name: 'id', value: '12')
      column(name: 'name', value: 'img.empty')
      column(name: 'restype', valueNumeric: 1)
      column(name: 'content', valueComputed: getTemplateFileContents('templates/default/empty.png'))
    }
  }

  changeSet(id: 'insertdata-41', author: 'kenneth.shaw@knq.io') {
    insert(tableName: 'resources') {
      column(name: 'id', value: '13')
      column(name: 'name', value: 'img.heart')
      column(name: 'restype', valueNumeric: 1)
      column(name: 'content', valueComputed: getTemplateFileContents('templates/default/heart.png'))
    }
  }

  changeSet(id: 'insertdata-42', author: 'kenneth.shaw@knq.io') {
    insert(tableName: 'resources') {
      column(name: 'id', value: '14')
      column(name: 'name', value: 'img.no_photo')
      column(name: 'restype', valueNumeric: 1)
      column(name: 'content', valueComputed: getTemplateFileContents('templates/default/no_photo.png'))
    }
  }

  changeSet(id: 'insertdata-43', author: 'kenneth.shaw@knq.io') {
    insert(tableName: 'resources') {
      column(name: 'id', value: '15')
      column(name: 'name', value: 'img.kit_print')
      column(name: 'restype', valueNumeric: 1)
      column(name: 'content', valueComputed: getTemplateFileContents('templates/default/kit_print.png'))
    }
  }

  changeSet(id: 'insertdata-44', author: 'kenneth.shaw@knq.io') {
    insert(tableName: 'resources') {
      column(name: 'id', value: '16')
      column(name: 'name', value: 'img.refundit')
      column(name: 'restype', valueNumeric: 1)
      column(name: 'content', valueComputed: getTemplateFileContents('templates/default/refundit.png'))
    }
  }

  changeSet(id: 'insertdata-45', author: 'kenneth.shaw@knq.io') {
    insert(tableName: 'resources') {
      column(name: 'id', value: '17')
      column(name: 'name', value: 'img.run_script')
      column(name: 'restype', valueNumeric: 1)
      column(name: 'content', valueComputed: getTemplateFileContents('templates/default/run_script.png'))
    }
  }

  changeSet(id: 'insertdata-46', author: 'kenneth.shaw@knq.io') {
    insert(tableName: 'resources') {
      column(name: 'id', value: '18')
      column(name: 'name', value: 'img.ticket_print')
      column(name: 'restype', valueNumeric: 1)
      column(name: 'content', valueComputed: getTemplateFileContents('templates/default/ticket_print.png'))
    }
  }

  changeSet(id: 'insertdata-47', author: 'kenneth.shaw@knq.io') {
    insert(tableName: 'resources') {
      column(name: 'id', value: '19')
      column(name: 'name', value: 'img.user')
      column(name: 'restype', valueNumeric: 1)
      column(name: 'content', valueComputed: getTemplateFileContents('templates/default/user.png'))
    }
  }

  changeSet(id: 'insertdata-48', author: 'kenneth.shaw@knq.io') {
    insert(tableName: 'resources') {
      column(name: 'id', value: '20')
      column(name: 'name', value: 'note.50')
      column(name: 'restype', valueNumeric: 1)
      column(name: 'content', valueComputed: getTemplateFileContents('templates/default/note.50.png'))
    }
  }

  changeSet(id: 'insertdata-49', author: 'kenneth.shaw@knq.io') {
    insert(tableName: 'resources') {
      column(name: 'id', value: '21')
      column(name: 'name', value: 'note.20')
      column(name: 'restype', valueNumeric: 1)
      column(name: 'content', valueComputed: getTemplateFileContents('templates/default/note.20.png'))
    }
  }

  changeSet(id: 'insertdata-50', author: 'kenneth.shaw@knq.io') {
    insert(tableName: 'resources') {
      column(name: 'id', value: '22')
      column(name: 'name', value: 'note.10')
      column(name: 'restype', valueNumeric: 1)
      column(name: 'content', valueComputed: getTemplateFileContents('templates/default/note.10.png'))
    }
  }

  changeSet(id: 'insertdata-51', author: 'kenneth.shaw@knq.io') {
    insert(tableName: 'resources') {
      column(name: 'id', value: '23')
      column(name: 'name', value: 'note.5')
      column(name: 'restype', valueNumeric: 1)
      column(name: 'content', valueComputed: getTemplateFileContents('templates/default/note.5.png'))
    }
  }

  changeSet(id: 'insertdata-52', author: 'kenneth.shaw@knq.io') {
    insert(tableName: 'resources') {
      column(name: 'id', value: '24')
      column(name: 'name', value: 'payment.cash')
      column(name: 'restype', valueNumeric: 0)
      column(name: 'content', valueComputed: getTemplateFileContents('templates/default/payment.cash.txt'))
    }
  }

  changeSet(id: 'insertdata-53', author: 'kenneth.shaw@knq.io') {
    insert(tableName: 'resources') {
      column(name: 'id', value: '25')
      column(name: 'name', value: 'Printer.CloseCash')
      column(name: 'restype', valueNumeric: 0)
      column(name: 'content', valueComputed: getTemplateFileContents('templates/default/Printer.CloseCash.xml'))
    }
  }

  changeSet(id: 'insertdata-54', author: 'kenneth.shaw@knq.io') {
    insert(tableName: 'resources') {
      column(name: 'id', value: '26')
      column(name: 'name', value: 'Printer.CustomerPaid')
      column(name: 'restype', valueNumeric: 0)
      column(name: 'content', valueComputed: getTemplateFileContents('templates/default/Printer.CustomerPaid.xml'))
    }
  }

  changeSet(id: 'insertdata-55', author: 'kenneth.shaw@knq.io') {
    insert(tableName: 'resources') {
      column(name: 'id', value: '27')
      column(name: 'name', value: 'Printer.CustomerPaid2')
      column(name: 'restype', valueNumeric: 0)
      column(name: 'content', valueComputed: getTemplateFileContents('templates/default/Printer.CustomerPaid2.xml'))
    }
  }

  changeSet(id: 'insertdata-56', author: 'kenneth.shaw@knq.io') {
    insert(tableName: 'resources') {
      column(name: 'id', value: '28')
      column(name: 'name', value: 'Printer.FiscalTicket')
      column(name: 'restype', valueNumeric: 0)
      column(name: 'content', valueComputed: getTemplateFileContents('templates/default/Printer.FiscalTicket.xml'))
    }
  }

  changeSet(id: 'insertdata-57', author: 'kenneth.shaw@knq.io') {
    insert(tableName: 'resources') {
      column(name: 'id', value: '29')
      column(name: 'name', value: 'Printer.Inventory')
      column(name: 'restype', valueNumeric: 0)
      column(name: 'content', valueComputed: getTemplateFileContents('templates/default/Printer.Inventory.xml'))
    }
  }

  changeSet(id: 'insertdata-58', author: 'kenneth.shaw@knq.io') {
    insert(tableName: 'resources') {
      column(name: 'id', value: '30')
      column(name: 'name', value: 'Printer.OpenDrawer')
      column(name: 'restype', valueNumeric: 0)
      column(name: 'content', valueComputed: getTemplateFileContents('templates/default/Printer.OpenDrawer.xml'))
    }
  }

  changeSet(id: 'insertdata-59', author: 'kenneth.shaw@knq.io') {
    insert(tableName: 'resources') {
      column(name: 'id', value: '43')
      column(name: 'name', value: 'script.AddLineNote')
      column(name: 'restype', valueNumeric: 0)
      column(name: 'content', valueComputed: getTemplateFileContents('templates/default/script.AddLineNote.txt'))
    }
  }

  changeSet(id: 'insertdata-60', author: 'kenneth.shaw@knq.io') {
    insert(tableName: 'resources') {
      column(name: 'id', value: '31')
      column(name: 'name', value: 'Printer.PartialCash')
      column(name: 'restype', valueNumeric: 0)
      column(name: 'content', valueComputed: getTemplateFileContents('templates/default/Printer.PartialCash.xml'))
    }
  }

  changeSet(id: 'insertdata-61', author: 'kenneth.shaw@knq.io') {
    insert(tableName: 'resources') {
      column(name: 'id', value: '32')
      column(name: 'name', value: 'Printer.Product')
      column(name: 'restype', valueNumeric: 0)
      column(name: 'content', valueComputed: getTemplateFileContents('templates/default/Printer.Product.xml'))
    }
  }

  changeSet(id: 'insertdata-62', author: 'kenneth.shaw@knq.io') {
    insert(tableName: 'resources') {
      column(name: 'id', value: '33')
      column(name: 'name', value: 'Printer.Start')
      column(name: 'restype', valueNumeric: 0)
      column(name: 'content', valueComputed: getTemplateFileContents('templates/default/Printer.Start.xml'))
    }
  }

  changeSet(id: 'insertdata-63', author: 'kenneth.shaw@knq.io') {
    insert(tableName: 'resources') {
      column(name: 'id', value: '34')
      column(name: 'name', value: 'Printer.Ticket')
      column(name: 'restype', valueNumeric: 0)
      column(name: 'content', valueComputed: getTemplateFileContents('templates/default/Printer.Ticket.xml'))
    }
  }

  changeSet(id: 'insertdata-64', author: 'kenneth.shaw@knq.io') {
    insert(tableName: 'resources') {
      column(name: 'id', value: '35')
      column(name: 'name', value: 'Printer.Ticket2')
      column(name: 'restype', valueNumeric: 0)
      column(name: 'content', valueComputed: getTemplateFileContents('templates/default/Printer.Ticket2.xml'))
    }
  }

  changeSet(id: 'insertdata-65', author: 'kenneth.shaw@knq.io') {
    insert(tableName: 'resources') {
      column(name: 'id', value: '36')
      column(name: 'name', value: 'Printer.TicketClose')
      column(name: 'restype', valueNumeric: 0)
      column(name: 'content', valueComputed: getTemplateFileContents('templates/default/Printer.TicketClose.xml'))
    }
  }

  changeSet(id: 'insertdata-66', author: 'kenneth.shaw@knq.io') {
    insert(tableName: 'resources') {
      column(name: 'id', value: '37')
      column(name: 'name', value: 'Printer.TicketKitchen')
      column(name: 'restype', valueNumeric: 0)
      column(name: 'content', valueComputed: getTemplateFileContents('templates/default/Printer.TicketKitchen.xml'))
    }
  }

  changeSet(id: 'insertdata-67', author: 'kenneth.shaw@knq.io') {
    insert(tableName: 'resources') {
      column(name: 'id', value: '38')
      column(name: 'name', value: 'Printer.TicketLine')
      column(name: 'restype', valueNumeric: 0)
      column(name: 'content', valueComputed: getTemplateFileContents('templates/default/Printer.TicketLine.xml'))
    }
  }

  changeSet(id: 'insertdata-68', author: 'kenneth.shaw@knq.io') {
    insert(tableName: 'resources') {
      column(name: 'id', value: '39')
      column(name: 'name', value: 'Printer.TicketNew')
      column(name: 'restype', valueNumeric: 0)
      column(name: 'content', valueComputed: getTemplateFileContents('templates/default/Printer.TicketNew.xml'))
    }
  }

  changeSet(id: 'insertdata-69', author: 'kenneth.shaw@knq.io') {
    insert(tableName: 'resources') {
      column(name: 'id', value: '40')
      column(name: 'name', value: 'Printer.TicketPreview')
      column(name: 'restype', valueNumeric: 0)
      column(name: 'content', valueComputed: getTemplateFileContents('templates/default/Printer.TicketPreview.xml'))
    }
  }

  changeSet(id: 'insertdata-70', author: 'kenneth.shaw@knq.io') {
    insert(tableName: 'resources') {
      column(name: 'id', value: '41')
      column(name: 'name', value: 'Printer.TicketTotal')
      column(name: 'restype', valueNumeric: 0)
      column(name: 'content', valueComputed: getTemplateFileContents('templates/default/Printer.TicketTotal.xml'))
    }
  }

  changeSet(id: 'insertdata-71', author: 'kenneth.shaw@knq.io') {
    insert(tableName: 'resources') {
      column(name: 'id', value: '42')
      column(name: 'name', value: 'Printer.Ticket.Logo')
      column(name: 'restype', valueNumeric: 1)
      column(name: 'content', valueComputed: getTemplateFileContents('templates/default/printer.ticket.logo.png'))
    }
  }

  changeSet(id: 'insertdata-73', author: 'kenneth.shaw@knq.io') {
    insert(tableName: 'resources') {
      column(name: 'id', value: '44')
      column(name: 'name', value: 'script.Event.Total')
      column(name: 'restype', valueNumeric: 0)
      column(name: 'content', valueComputed: getTemplateFileContents('templates/default/script.Event.Total.txt'))
    }
  }

  changeSet(id: 'insertdata-74', author: 'kenneth.shaw@knq.io') {
    insert(tableName: 'resources') {
      column(name: 'id', value: '45')
      column(name: 'name', value: 'script.linediscount')
      column(name: 'restype', valueNumeric: 0)
      column(name: 'content', valueComputed: getTemplateFileContents('templates/default/script.linediscount.txt'))
    }
  }

  changeSet(id: 'insertdata-75', author: 'kenneth.shaw@knq.io') {
    insert(tableName: 'resources') {
      column(name: 'id', value: '46')
      column(name: 'name', value: 'script.ReceiptConsolidate')
      column(name: 'restype', valueNumeric: 0)
      column(name: 'content', valueComputed: getTemplateFileContents('templates/default/script.ReceiptConsolidate.txt'))
    }
  }

  changeSet(id: 'insertdata-76', author: 'kenneth.shaw@knq.io') {
    insert(tableName: 'resources') {
      column(name: 'id', value: '47')
      column(name: 'name', value: 'script.Refundit')
      column(name: 'restype', valueNumeric: 0)
      column(name: 'content', valueComputed: getTemplateFileContents('templates/default/script.Refundit.txt'))
    }
  }

  changeSet(id: 'insertdata-77', author: 'kenneth.shaw@knq.io') {
    insert(tableName: 'resources') {
      column(name: 'id', value: '48')
      column(name: 'name', value: 'script.SendOrder')
      column(name: 'restype', valueNumeric: 0)
      column(name: 'content', valueComputed: getTemplateFileContents('templates/default/script.SendOrder.txt'))
    }
  }

  changeSet(id: 'insertdata-78', author: 'kenneth.shaw@knq.io') {
    insert(tableName: 'resources') {
      column(name: 'id', value: '49')
      column(name: 'name', value: 'script.ServiceCharge')
      column(name: 'restype', valueNumeric: 0)
      column(name: 'content')
    }
  }

  changeSet(id: 'insertdata-79', author: 'kenneth.shaw@knq.io') {
    insert(tableName: 'resources') {
      column(name: 'id', value: '50')
      column(name: 'name', value: 'script.SetPerson')
      column(name: 'restype', valueNumeric: 0)
      column(name: 'content', valueComputed: getTemplateFileContents('templates/default/script.SetPerson.txt'))
    }
  }

  changeSet(id: 'insertdata-80', author: 'kenneth.shaw@knq.io') {
    insert(tableName: 'resources') {
      column(name: 'id', value: '51')
      column(name: 'name', value: 'script.StockCurrentAdd')
      column(name: 'restype', valueNumeric: 0)
      column(name: 'content', valueComputed: getTemplateFileContents('templates/default/script.StockCurrentAdd.txt'))
    }
  }

  changeSet(id: 'insertdata-81', author: 'kenneth.shaw@knq.io') {
    insert(tableName: 'resources') {
      column(name: 'id', value: '52')
      column(name: 'name', value: 'script.StockCurrentSet')
      column(name: 'restype', valueNumeric: 0)
      column(name: 'content', valueComputed: getTemplateFileContents('templates/default/script.StockCurrentSet.txt'))
    }
  }

  changeSet(id: 'insertdata-82', author: 'kenneth.shaw@knq.io') {
    insert(tableName: 'resources') {
      column(name: 'id', value: '53')
      column(name: 'name', value: 'script.totaldiscount')
      column(name: 'restype', valueNumeric: 0)
      column(name: 'content', valueComputed: getTemplateFileContents('templates/default/script.totaldiscount.txt'))
    }
  }

  changeSet(id: 'insertdata-83', author: 'kenneth.shaw@knq.io') {
    insert(tableName: 'resources') {
      column(name: 'id', value: '54')
      column(name: 'name', value: 'Ticket.Buttons')
      column(name: 'restype', valueNumeric: 0)
      column(name: 'content', valueComputed: getTemplateFileContents('templates/default/Ticket.Buttons.xml'))
    }
  }

  changeSet(id: 'insertdata-84', author: 'kenneth.shaw@knq.io') {
    insert(tableName: 'resources') {
      column(name: 'id', value: '55')
      column(name: 'name', value: 'Ticket.Close')
      column(name: 'restype', valueNumeric: 0)
      column(name: 'content', valueComputed: getTemplateFileContents('templates/default/Ticket.Close.xml'))
    }
  }

  changeSet(id: 'insertdata-85', author: 'kenneth.shaw@knq.io') {
    insert(tableName: 'resources') {
      column(name: 'id', value: '56')
      column(name: 'name', value: 'Ticket.Discount')
      column(name: 'restype', valueNumeric: 0)
      column(name: 'content', valueComputed: getTemplateFileContents('templates/default/Ticket.Discount.xml'))
    }
  }

  changeSet(id: 'insertdata-86', author: 'kenneth.shaw@knq.io') {
    insert(tableName: 'resources') {
      column(name: 'id', value: '57')
      column(name: 'name', value: 'Ticket.Line')
      column(name: 'restype', valueNumeric: 0)
      column(name: 'content', valueComputed: getTemplateFileContents('templates/default/Ticket.Line.xml'))
    }
  }

  changeSet(id: 'insertdata-87', author: 'kenneth.shaw@knq.io') {
    insert(tableName: 'resources') {
      column(name: 'id', value: '58')
      column(name: 'name', value: 'Ticket.TicketLineTaxesIncluded')
      column(name: 'restype', valueNumeric: 0)
      column(name: 'content', valueComputed: getTemplateFileContents('templates/default/Ticket.TicketLineTaxesIncluded.xml'))
    }
  }

  changeSet(id: 'insertdata-88', author: 'kenneth.shaw@knq.io') {
    insert(tableName: 'resources') {
      column(name: 'id', value: '59')
      column(name: 'name', value: 'Window.Logo')
      column(name: 'restype', valueNumeric: 1)
      column(name: 'content', valueComputed: getTemplateFileContents('templates/default/Window.Logo.png'))
    }
  }

  changeSet(id: 'insertdata-89', author: 'kenneth.shaw@knq.io') {
    insert(tableName: 'resources') {
      column(name: 'id', value: '60')
      column(name: 'name', value: 'Window.Title')
      column(name: 'restype', valueNumeric: 0)
      column(name: 'content', valueComputed: getTemplateFileContents('templates/default/Window.Title.txt'))
    }
  }

  changeSet(id: 'insertdata-90', author: 'kenneth.shaw@knq.io') {
    insert(tableName: 'resources') {
      column(name: 'id', value: '10e0f3f0-0bd6-4e0b-bcd6-2077f3d6ef51')
      column(name: 'name', value: 'ken-desktop/properties')
      column(name: 'restype', valueNumeric: 0)
      column(name: 'content', valueComputed: getTemplateFileContents('templates/default/ken-desktop.properties.xml'))
    }
  }

  changeSet(id: 'insertdata-91', author: 'kenneth.shaw@knq.io') {
    insert(tableName: 'roles') {
      column(name: 'id', value: '0')
      column(name: 'name', value: 'Administrator role')
      column(name: 'permissions', valueComputed: getTemplateFileContents('templates/default/Role.Administrator.xml'))
    }
  }

  changeSet(id: 'insertdata-92', author: 'kenneth.shaw@knq.io') {
    insert(tableName: 'roles') {
      column(name: 'id', value: '1')
      column(name: 'name', value: 'Manager role')
      column(name: 'permissions', valueComputed: getTemplateFileContents('templates/default/Role.Manager.xml'))
    }
  }

  changeSet(id: 'insertdata-93', author: 'kenneth.shaw@knq.io') {
    insert(tableName: 'roles') {
      column(name: 'id', value: '2')
      column(name: 'name', value: 'Employee role')
      column(name: 'permissions', valueComputed: getTemplateFileContents('templates/default/Role.Employee.xml'))
    }
  }

  changeSet(id: 'insertdata-94', author: 'kenneth.shaw@knq.io') {
    insert(tableName: 'roles') {
      column(name: 'id', value: '3')
      column(name: 'name', value: 'Guest role')
      column(name: 'permissions', valueComputed: getTemplateFileContents('templates/default/Role.Guest.xml'))
    }
  }

  changeSet(id: 'insertdata-95', author: 'kenneth.shaw@knq.io') {
    insert(tableName: 'shifts') {
      column(name: 'id', value: '0')
      column(name: 'startshift', valueDate: '2013-09-01T00:00:00.001')
      column(name: 'endshift', valueDate: '2013-09-01T00:00:00.002')
      column(name: 'pplid', value: '0')
    }
  }

  changeSet(id: 'insertdata-96', author: 'kenneth.shaw@knq.io') {
    insert(tableName: 'shift_breaks') {
      column(name: 'id', value: '0')
      column(name: 'shiftid', value: '0')
      column(name: 'breakid', value: '0')
      column(name: 'starttime', valueDate: '2013-09-01T00:00:00.003')
      column(name: 'endtime', valueDate: '2013-09-01T00:00:00.004')
    }
  }

  changeSet(id: 'insertdata-97', author: 'kenneth.shaw@knq.io') {
    insert(tableName: 'taxcategories') {
      column(name: 'id', value: '000')
      column(name: 'name', value: 'Tax Exempt')
    }
  }

  changeSet(id: 'insertdata-98', author: 'kenneth.shaw@knq.io') {
    insert(tableName: 'taxcategories') {
      column(name: 'id', value: '001')
      column(name: 'name', value: 'Tax Standard')
    }
  }

  changeSet(id: 'insertdata-99', author: 'kenneth.shaw@knq.io') {
    insert(tableName: 'taxes') {
      column(name: 'id', value: '000')
      column(name: 'name', value: 'Tax Exempt')
      column(name: 'category', value: '000')
      column(name: 'custcategory')
      column(name: 'parentid')
      column(name: 'rate', valueNumeric: 0.0)
      column(name: 'ratecascade', valueBoolean: false)
      column(name: 'rateorder')
    }
  }

  changeSet(id: 'insertdata-100', author: 'kenneth.shaw@knq.io') {
    insert(tableName: 'taxes') {
      column(name: 'id', value: '001')
      column(name: 'name', value: 'Tax Standard')
      column(name: 'category', value: '001')
      column(name: 'custcategory')
      column(name: 'parentid')
      column(name: 'rate', valueNumeric: 0.1)
      column(name: 'ratecascade', valueBoolean: false)
      column(name: 'rateorder')
    }
  }

  changeSet(id: 'insertdata-10', author: 'kenneth.shaw@knq.io') {
    insert(tableName: 'people') {
      column(name: 'id', value: '0')
      column(name: 'name', value: 'Administrator')
      column(name: 'apppassword')
      column(name: 'card')
      column(name: 'role', value: '0')
      column(name: 'visible', valueBoolean: true)
      column(name: 'image')
    }
  }

  changeSet(id: 'insertdata-11', author: 'kenneth.shaw@knq.io') {
    insert(tableName: 'people') {
      column(name: 'id', value: '1')
      column(name: 'name', value: 'Manager')
      column(name: 'apppassword')
      column(name: 'card')
      column(name: 'role', value: '1')
      column(name: 'visible', valueBoolean: true)
      column(name: 'image')
    }
  }

  changeSet(id: 'insertdata-12', author: 'kenneth.shaw@knq.io') {
    insert(tableName: 'people') {
      column(name: 'id', value: '2')
      column(name: 'name', value: 'Employee')
      column(name: 'apppassword')
      column(name: 'card')
      column(name: 'role', value: '2')
      column(name: 'visible', valueBoolean: true)
      column(name: 'image')
    }
  }

  changeSet(id: 'insertdata-13', author: 'kenneth.shaw@knq.io') {
    insert(tableName: 'people') {
      column(name: 'id', value: '3')
      column(name: 'name', value: 'Guest')
      column(name: 'apppassword')
      column(name: 'card')
      column(name: 'role', value: '3')
      column(name: 'visible', valueBoolean: true)
      column(name: 'image')
    }
  }

  changeSet(id: 'insertdata-26', author: 'kenneth.shaw@knq.io') {
    insert(tableName: 'products') {
      column(name: 'id', value: 'xxx999_999xxx_x9x9x9')
      column(name: 'reference', value: 'xxx999')
      column(name: 'code', value: 'xxx999')
      column(name: 'codetype')
      column(name: 'name', value: '***')
      column(name: 'pricebuy', valueNumeric: 0.0)
      column(name: 'pricesell', valueNumeric: 0.0)
      column(name: 'category', value: '000')
      column(name: 'taxcat', value: '001')
      column(name: 'attributeset_id')
      column(name: 'stockcost')
      column(name: 'stockvolume')
      column(name: 'image')
      column(name: 'iscom', valueBoolean: false)
      column(name: 'isscale', valueBoolean: false)
      column(name: 'iskitchen', valueBoolean: false)
      column(name: 'printkb', valueBoolean: false)
      column(name: 'sendstatus', valueBoolean: false)
      column(name: 'isservice', valueBoolean: true)
      column(name: 'display')
      column(name: 'attributes')
      column(name: 'isvprice', valueBoolean: false)
      column(name: 'isverpatrib', valueBoolean: false)
      column(name: 'texttip')
      column(name: 'warranty', valueBoolean: false)
      column(name: 'stockunits', valueNumeric: 0.0)
    }
  }

}
