import fs from "fs";

export function authenticationMiddleware(req, res, next) {
  const authToken = req.headers.authorization;

  if (!authToken) {
    return res.status(401).json({ message: "Unauthorized" });
  }
  next();
}

export function logDateMiddleware(req, res, next) {
  const logMessage = `Date: ${new Date().toUTCString()}, URL: ${
    req.url
  }, Method: ${req.method}, Status Code: ${res.statusCode}\n`;
  fs.appendFile("request_logs.txt", logMessage, (err) => {
    if (err) {
      console.error("Erreur lors de la journalisation de la requête : ", err);
    }
  });

  next();
}
