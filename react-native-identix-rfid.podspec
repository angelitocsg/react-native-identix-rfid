require "json"

package = JSON.parse(File.read(File.join(__dir__, "package.json")))

Pod::Spec.new do |s|
  s.name         = "react-native-identix-rfid"
  s.version      = package["version"]
  s.summary      = package["description"]
  s.description  = <<-DESC
                  react-native-identix-rfid
                   DESC
  s.homepage     = "https://github.com/angelitocsg/react-native-identix-rfid"
  # brief license entry:
  s.license      = "MIT"
  # optional - use expanded license entry instead:
  s.license    = { :type => "MIT", :file => "LICENSE" }
  s.authors      = { "Angelito Casagrande" => "angelito@angelito.com.brs" }
  s.platforms    = { :ios => "9.0" }
  s.source       = { :git => "https://github.com/angelitocsg/react-native-identix-rfid.git", :tag => "#{s.version}" }

  s.source_files = "ios/**/*.{h,m,swift}"
  s.requires_arc = true

  s.dependency "React"
  # ...
  # s.dependency "..."
end

