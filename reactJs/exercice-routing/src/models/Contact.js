class Contact {
  constructor(firstname, lastname, email, telephone) {
    this.id = new Date().getTime().toString();
    this.firstname = firstname;
    this.lastname = lastname;
    this.email = email;
    this.telephone = telephone;
  }
}

export default Contact;
